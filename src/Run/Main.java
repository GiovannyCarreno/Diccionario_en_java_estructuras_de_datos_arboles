package Run;

import Interfase.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.main();
    }

    /*public static void consola(){
        Scanner scanner = new Scanner(System.in);
        Dictionary dic = new Dictionary();
        dic.loadData();

        *//*String word = "Perro";
        String meaning = "Animal que deciende de los lobos";
        String translate = "dog";
        char first = word.toUpperCase().charAt(0);
        int assci = (int) first == 209 ? (int) first - 118 : (int) first ;

        dic.add(word, meaning, translate, assci - 65);

        for (Word palabra : dic.getList().get(assci - 65).listInsort()) {
            System.out.println(palabra);
        }*//*

        Files files = new Files();

        //files.SobreescribirInformacion("Data/words.txt","perro");

        boolean salir = false;

        do{
            System.out.println("            DICCIONARIO\n" +
                    "1. Consultar palabra\n" +
                    "2. Agregar palabra\n" +
                    "3. Modificar palabra\n" +
                    "4. Eliminar palabra\n" +
                    "5. Consultar todas las palabras por una letra\n" +
                    "6. Salir");
            int op = 0;
            try {
                op = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){

            }
            switch (op){
                case 1:
                    System.out.println("Digite la palabra que desea buscar");
                    String letter4 = scanner.nextLine().toLowerCase().replace(" ","");
                    char first4 = letter4.toUpperCase().charAt(0);
                    int assci4 = (int) first4 == 209 ? (int) first4 - 118 : (int) first4;
                    if(dic.findWord(letter4,assci4-65) != null){
                        System.out.println(dic.findWord(letter4,assci4-65).getInfo());
                    }else{
                        System.out.println("The word doesnt exist");
                    }
                    break;
                case 2:
                    System.out.println("Digite la palabra");
                    String word2 = scanner.nextLine().toLowerCase().replace(" ","");
                    System.out.println("Digite el significado");
                    String meaning2 = scanner.nextLine();
                    System.out.println("Digite la traduccion al ingles");
                    String translate2 = scanner.nextLine();
                    char first2 = word2.toUpperCase().charAt(0);
                    int assci2 = (int) first2 == 209 ? (int) first2 - 118 : (int) first2;
                    dic.add(word2, meaning2, translate2, assci2 - 65);
                    dic.addWordData(word2, meaning2, translate2);
                    break;
                case 3:
                    System.out.println("Digite la palabra que desea modificar");
                    String letter6 = scanner.nextLine().toLowerCase().replace(" ","");
                    char first6 = letter6.toUpperCase().charAt(0);
                    int assci6 = (int) first6 == 209 ? (int) first6 - 118 : (int) first6;
                    if(dic.findWord(letter6,assci6-65) != null){
                        System.out.println("Digite el nuevo significado");
                        String meaning6 = scanner.nextLine();
                        System.out.println("Digite la traduccion al ingles");
                        String translate6 = scanner.nextLine();
                        dic.modifyWord(letter6,meaning6,translate6,assci6-65);
                    }else{
                        System.out.println("The word doesnt exist");
                    }
                    dic.rewrite();
                    break;
                case 4:
                    System.out.println("Digite la palabra que desea eliminar");
                    String word5 = scanner.nextLine().toLowerCase().replace(" ","");
                    char first5 = word5.toUpperCase().charAt(0);
                    int assci5 = (int) first5 == 209 ? (int) first5 - 118 : (int) first5;
                    dic.deleteWord(word5,assci5-65);
                    break;
                case 5:
                    System.out.println("Digite una letra del abecedario para ver todas las palabras que empiezan por dicha letra");
                    String letter3 = scanner.nextLine().toLowerCase().replace(" ","");
                    char first3 = letter3.toUpperCase().charAt(0);
                    int assci3 = (int) first3 == 209 ? (int) first3 - 118 : (int) first3 ;
                    try {
                        for (Word palabra : dic.getList().get(assci3 - 65).listInsort()) {
                            System.out.println(palabra);
                        }
                        if(dic.getList().get(assci3 - 65).listInsort().size() == 0){
                            System.out.println("There is not words by that letter");
                        }
                    }catch (Exception e){
                        System.out.println("There is not words by that letter");
                    }
                    break;
                case 6: salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (salir == false);
    }*/
}