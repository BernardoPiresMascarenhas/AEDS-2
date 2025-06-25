import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Show {
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private Date date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String[] listed_in;

    //CONSTRUTORES
    public Show() {
        this.show_id = "";
        this.type = "";
        this.title = "";
        this.director = "";
        this.cast = new String[0];
        this.country = "";
        this.date_added = null;
        this.release_year = 0;
        this.rating = "";
        this.duration = "";
        this.listed_in = new String[0];
    }

    public Show(String show_id, String type, String title, String director, String[] cast, String country,
                Date date_added, int release_year, String rating, String duration, String[] listed_in) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
    }

    //GETTERS
    public String getShow_id() { return show_id; }
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String[] getCast() { return cast; }
    public String getCountry() { return country; }
    public Date getDate_added() { return date_added; }
    public int getRelease_year() { return release_year; }
    public String getRating() { return rating; }
    public String getDuration() { return duration; }
    public String[] getListed_in() { return listed_in; }

    //SETTERS
    public void setShow_id(String show_id) { this.show_id = show_id; }
    public void setType(String type) { this.type = type; }
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setCast(String[] cast) { this.cast = cast; }
    public void setCountry(String country) { this.country = country; }
    public void setDate_added(Date date_added) { this.date_added = date_added; }
    public void setRelease_year(int release_year) { this.release_year = release_year; }
    public void setRating(String rating) { this.rating = rating; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setListed_in(String[] listed_in) { this.listed_in = listed_in; }


    //LEITURA
    public static void leiaShow(Show[] show) throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/disneyplus.csv"), StandardCharsets.UTF_8));
        file.readLine(); 

        String linha;
        while ((linha = file.readLine()) != null) {
            String[] divisao = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            for (int i = 0; i < divisao.length; i++) {
                divisao[i] = divisao[i].replaceAll("^\"|\"$", "").trim();
            }

            int index = Integer.parseInt(divisao[0].substring(1)) - 1;

            String[] cast = divisao.length > 4 && !divisao[4].isEmpty() ? divisao[4].split(",\\s*") : new String[0];
            for (int i = 0; i < cast.length; i++) {
                cast[i] = titleHasAspas(cast[i]);
            }
            ordenandoVetor(cast);

            if (divisao.length <= 6 || divisao[6].isEmpty()) {
                divisao[6] = "March 1, 1900";
            }
            Date date;
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            date = formatter.parse(divisao[6]);

            int ano = Integer.parseInt(divisao[7]);
            String[] listed = divisao.length > 10 && !divisao[10].isEmpty() ? divisao[10].split(",\\s*") : new String[0];
            for (int i = 0; i < listed.length; i++) {
                listed[i] = titleHasAspas(listed[i]);
            }
            ordenandoVetor(listed); 

            show[index] = new Show(divisao[0], divisao[1], titleHasAspas(divisao[2]), divisao[3], cast,
                    divisao[5], date, ano, divisao[8], divisao[9], listed);
        }
        file.close();
    }

    public static void ordenandoVetor(String[] ordenar) {
        for (int i = 0; i < ordenar.length - 1; i++) {
            for (int j = i + 1; j < ordenar.length; j++) {
                if (ehMaior(ordenar[i], ordenar[j])) {
                    String tmp = ordenar[i];
                    ordenar[i] = ordenar[j];
                    ordenar[j] = tmp;
                }
            }
        }
    }
    
    public static String titleHasAspas(String title) {
        StringBuilder sb = new StringBuilder(title.length());
        boolean aspasAnterior = false;
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (c != '"') {
                if (aspasAnterior && c != ' ' && sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(c);
                aspasAnterior = false;
            } else {
                aspasAnterior = true;
            }
        }
        return sb.toString();
    }

    public static boolean ehMaior(String menor, String maior) {
        boolean ehMaior = false;
        String[] str1 = menor.split(" "), str2 = maior.split(" ");
        if (str1[0].compareTo(str2[0]) > 0) {
            ehMaior = true;
        } else if (str1[0].compareTo(str2[0]) == 0) {
            if (str1.length > 1 && str2.length > 1) {
                if (str1[1].compareTo(str2[1]) > 0) {
                    ehMaior = true;
                }
            }
        }
        return ehMaior;
    }
}

class No {
    int chave; 
    Arvore2 elemento; 
    No dir, esq;

    public No(int x) {
        this.chave = x;
        this.elemento = new Arvore2();
        this.dir = null;
        this.esq = null;
    }
}


class No2 {
    Show elemento; 
    No2 dir, esq;

    public No2(Show x) {
        this.elemento = x;
        this.dir = null;
        this.esq = null;
    }
}


class Arvore {
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(Show s) {
        int key = s.getRelease_year() % 15;
        this.raiz = inserir(s, key, this.raiz);
    }

    private No inserir(Show s, int key, No n) {
        if (n == null) {
            n = new No(key);
            n.elemento.inserir(s);
        } else if (key < n.chave) {
            n.esq = inserir(s, key, n.esq);
        } else if (key > n.chave) {
            n.dir = inserir(s, key, n.dir);
        } else {

            n.elemento.inserir(s);
        }
        return n;
    }

    public boolean pesquisar(String titulo) {
        System.out.print("raiz ");
        return pesquisar(titulo, this.raiz);
    }

    private boolean pesquisar(String titulo, No n) {
        boolean encontrado = false;
        if (n != null) {

            encontrado = n.elemento.pesquisar(titulo);
            

            if (!encontrado) {
                System.out.print("esq ");
                encontrado = pesquisar(titulo, n.esq);
            }
            

            if (!encontrado) {
                System.out.print("dir ");
                encontrado = pesquisar(titulo, n.dir);
            }
        }
        return encontrado;
    }
}


class Arvore2 {
    No2 raiz;

    Arvore2() {
        this.raiz = null;
    }

    public void inserir(Show s) {
        this.raiz = inserir(s, this.raiz);
    }

    private No2 inserir(Show s, No2 n) {
        if (n == null) {
            n = new No2(s);
        } else if (s.getTitle().compareTo(n.elemento.getTitle()) < 0) {
            n.esq = inserir(s, n.esq);
        } else if (s.getTitle().compareTo(n.elemento.getTitle()) > 0) {
            n.dir = inserir(s, n.dir);
        }
      
        return n;
    }

    public boolean pesquisar(String titulo) {
        System.out.print("raiz ");
        return pesquisar(titulo, this.raiz);
    }

    private boolean pesquisar(String titulo, No2 n) {
        if (n == null) {
            return false;
        }

        int comparacao = titulo.compareTo(n.elemento.getTitle());

        if (comparacao == 0) {
            return true; 
        } else if (comparacao < 0) {
            System.out.print("esq ");
            return pesquisar(titulo, n.esq);
        } else {
            System.out.print("dir ");
            return pesquisar(titulo, n.dir);
        }
    }
}

public class Main {
    
    static Show[] show = new Show[1423];

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        Show.leiaShow(show);
        Arvore arvore = new Arvore();

        String linha = sc.nextLine();
        while (!linha.equals("FIM")) {
            int index = Integer.parseInt(linha.substring(1)) - 1;
            if (index >= 0 && index < show.length && show[index] != null) {
                arvore.inserir(show[index]);
            }
            linha = sc.nextLine();
        }

        linha = sc.nextLine();
        while (!linha.equals("FIM")) {
            System.out.print(linha + " ");
            if (arvore.pesquisar(linha)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            linha = sc.nextLine();
        }
        sc.close();
    }
}