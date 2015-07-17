/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.bd2hibernate.cgt;

import br.edu.ifes.bd2hibernate.cdp.Jogador;
import br.edu.ifes.bd2hibernate.cdp.Time;
import br.edu.ifes.bd2hibernate.cgd.HibernateUtil;
import br.edu.ifes.bd2hibernate.util.DateValidator;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

/**
 *
 * @author aleao
 */
public class Menu {
    
    DateValidator dateValidator = new DateValidator();
    HashMap<String, String> messages = new HashMap<String, String>();
    DataFactory df = new DataFactory();
    
    public Menu(){
        //Inicializa o Hibernate
        HibernateUtil.getSession();
        //Limpa o log de inicialização
        FuncaozinhaIradaPraLimparATelaNoMelhorEstiloJavaDeSer();
        
        this.messages.put("NOME", "Nome: ");
        this.messages.put("ID", "Id: ");
        this.messages.put("DATACRIACAO", "Data (dd/MM/yyyy): ");
        this.messages.put("DATANASCIMENTO", "Data (dd/MM/yyyy): ");
        this.messages.put("ENDERECO", "Endereco: ");
        this.messages.put("MENSALIDADESOCIO", "Mensalidade (Ex: 1.99): ");
        
        
        this.messages.put("SUCESSO_INSERIR", "\n%1$s Inserido com sucesso\n");
        this.messages.put("SUCESSO_DELETAR", "\n%1$s Excluido com sucesso\n");
        this.messages.put("SUCESSO_ATUALIZAR", "\n%1$s Atualizado com sucesso\n");
        this.messages.put("INICIANDO_POPULACAO", "Iniciando População do Banco...\n");
        this.messages.put("ENCERRANDO_POPULACAO", "...Encerrando População do Banco\n\nBanco Populado com Sucesso!\n");
        this.messages.put("TIME_REQUIRIDO", "\nEscolha um dos seguintes times:\n");
    }
    
    public void load() {
        Scanner menuEntrada = new Scanner(System.in);
        int menu = -1;
        while (menu != 0) {
            System.out.println("1 - Cadastrar Jogador");
            System.out.println("2 - Cadastrar Time");
            System.out.println("3 - Listar Times");
            System.out.println("4 - Listar Jogadores");
            System.out.println("5 - Buscar Jogador");
            System.out.println("6 - Buscar Time");
            System.out.println("7 - Buscar Jogadores do Time");
            System.out.println("0 - Sair");
            
            menu = menuEntrada.nextInt();
            switch (menu) {
                case 1:
                    cadastrarJogador(lerJogador());
                    imprimeMensagem("Jogador", "inserir");
                    break;
                case 2:
                    cadastrarTime(lerTime());
                    imprimeMensagem("Time", "inserir");
                    break;
                case 3:
                    listar(buscarTodosTimes());
                    break;
                case 4:
                    listar(buscarTodosJogadores());
                    break;
                case 5:
                    System.out.println(new Jogador().selecionar(lerInt()));
                    break;
                case 6:
                    System.out.println(new Time().selecionar(lerInt()));
                    break;
                case 7:
                    listarJogadoresDoTime();
                    break;
                case 0:
                    HibernateUtil.shutdown();
                    return;
            }
        }
    }
    
    private void imprimeMensagem(String objeto, String operacao){
        operacao = operacao.toUpperCase();
        System.out.println(String.format(this.messages.get("SUCESSO_"+operacao),objeto));
    }
    
    private void listarJogadoresDoTime(){
        listar(buscarTodosTimes());
        System.out.println("Informe o time desejado:");
        int idTime = lerInt();
        Time t = new Time().selecionar(idTime);
        
        List<Jogador> jogadores = new Jogador().selecionar(t.getNome());
        listar(jogadores);
    }
    
    private int lerInt() {
        System.out.println(this.messages.get("ID"));
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        return id;
    }
    
    private List<Jogador> buscarTodosJogadores(){
        return new Jogador().selecionarTodos();
    }
    
    private List<Time> buscarTodosTimes(){
        return new Time().selecionarTodos();
    }
    
    public void FuncaozinhaIradaPraLimparATelaNoMelhorEstiloJavaDeSer(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    
    private void listar(List<?> objects){
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    private void cadastrarJogador(Jogador jogador) {
        jogador.inserir(jogador);
    }
    
    private Jogador lerJogador(){
        
        System.out.println(this.messages.get("TIME_REQUIRIDO"));
        listar(buscarTodosTimes());
        int idTime = lerInt();
        Time time = new Time().selecionar(idTime);
        
        Jogador j = new Jogador();
        setValue("nome", j);
        setValue("dataNascimento", j);
        setValue("endereco", j);
        j.setTime(time);
        return j;
    }
    
    
    private void cadastrarTime(Time time){
        time.inserir(time);
    }
    
    private Time lerTime(){
        Time t = new Time();
        setValue("nome", t);
        setValue("dataCriacao", t);
        setValue("mensalidadeSocio", t);
        return t;
    }
    
    //TODO: Melhore num FORK
    private Object scanSpecific(String fieldName, Scanner sc, Class c) throws NoSuchFieldException{
        
        Field field = c.getDeclaredField(fieldName);
        boolean valid = false;
        Object value = null;
        
        while(!valid){
            System.out.println(this.messages.get(fieldName.toUpperCase()));
            String type = field.getType().getSimpleName();

            switch (type.toUpperCase()) {
                case "STRING":
                    value = sc.nextLine();
                    valid = true;
                    break;
                case "DATE":
                    String date = sc.nextLine();
                    valid = this.dateValidator.validate(date);
                    if(valid)
                        value = convertStringToDate(date);
                    break;
                case "INT":
                    value = sc.nextInt();
                    valid = true;
                    break;
                case "FLOAT":
                    value = sc.nextFloat();
                    valid = true;
                    break;
            }
        }
        
        return value;
    }
    
    
    private void setValue(String field, Object objeto){
        
        PropertyAccessor propAccessor = PropertyAccessorFactory.forBeanPropertyAccess(objeto);   
        Scanner sc = new Scanner(System.in);
        
        Object valorModificado = null;
        Object valorAtual;
        
        do {
            try {
                valorModificado = scanSpecific(field, sc, objeto.getClass());
            } catch (NoSuchFieldException ex) {
                ex.printStackTrace();
            }

            propAccessor.setPropertyValue(field, valorModificado);
            valorAtual = propAccessor.getPropertyValue(field);
            
            if(valorAtual == null)
                valorAtual = new Object();
            
        } while (! valorAtual.equals(valorModificado)) ;
    }
    
    private Date convertStringToDate(String dataRecebida) {
        
        Date dataNascimento = null;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            dataNascimento = df.parse(dataRecebida);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dataNascimento;
    }
}
