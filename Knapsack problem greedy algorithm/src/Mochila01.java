import java.util.*;

//Vamos a elegir los objetos con el mayor ratio (Beneficio/Peso máximo)
public class Mochila01 {


    private static int[] Solución(Objeto[] lista, int pesoMax){
        int[] sol = new int[lista.length];

        //redefinicion del metodo sort para ordenar los objetos con el criterio de ratio peso/beneficio
        Arrays.sort(lista, new Comparator<Objeto>(){
            @Override
            public int compare(Objeto obj1, Objeto obj2){
                double r1 = obj1.valor/ obj1.peso;
                double r2 = obj2.valor/ obj2.peso;

                if(r1 < r2 ){
                    return 1;
                }else{
                    return -1;
                }

            }
        });
        //Hasta aqui los objetos estan ordenados por el valor de su ratio.
        //Lo iremos cogiendo por mayor ratio.
        //Segun vayan entrando en la mochila si el peso maximo lo permite
        int i=0;
        int capacidad = pesoMax;
        while( i<lista.length && lista[i].peso<= capacidad ){
            capacidad = capacidad-lista[i].peso;
            sol[i]=1;
            i++;
            if(i<= lista.length){
                sol[i] = capacidad/lista[i].peso;
            }
        }
        return sol;
    }

    private static class Objeto {
        int  peso,valor;

        public Objeto (int peso,int  valor){
            this.peso=peso;
            this.valor=valor;
        }
        @Override
        public String toString(){
            return "Objeto peso: "+peso+"  valor: "+valor+"\n";
        }

    }

    public static void  main (String[] args){


        Objeto[] lista = {new Objeto(10,60), new Objeto(20,100), new Objeto(30,120), new Objeto(15,70)};
        int pesoMax=50;

        //array solucion que nos dira que objetos entraran en la mochila final.
        int[] sol = Solución(lista, pesoMax);
        for(int i=0; i< sol.length; i++){
            System.out.print("["+sol[i]+"] ");
        }



    }
}



