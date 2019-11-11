package pe.com.eteralblue.vistacontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matriz {
	static BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));        
    public static int opc, fila, colum, fila2, colum2;
    public static double [][] m1;
    public static double [][] m2;
    
    public static void saltodelinea(int cantidad) {
    	for (int i = 0; i < cantidad; i++) {
			System.out.println(" ");
		}
    }
    public static void main(String[] args) throws IOException {                
        do {  
        	saltodelinea(3);
            System.out.println("*-*-*-*-*-*- MATRICES *-*-*-*-*-*- " );
            saltodelinea(2);
            System.out.println("1.- Introducir matriz A n " );
            System.out.println("2.- Introducir matriz B n " );
            System.out.println("3.- Calcular: A + B n " );
            System.out.println("4.- Calcular: A - B n " );
            System.out.println("5.- Calcular: A * B n " );
            System.out.println("6.- Calcular: Det(A) n  " );
            System.out.println("7.- Calcular: A ^ t n " );
            System.out.println("8.- Calcular: A ^ -1 n " );
            System.out.println("9.- SALIR " );        
            System.out.print("Elige una opcion [1-9]:  " );
            opc=Integer.parseInt( entrada.readLine());
            switch(opc){
                case 1: matriz1();
                        break;
                case 2: matriz2();
                        break;
                case 3: sumar();
                        break;
                case 4: restar();
                        break;
                case 5: multi();
                        break;
                case 6: deta();
                        break;
                case 7:traa();
                        break;
                case 8:inva();
                        break; 
                case 9:salir();
                		break; 
                default:
    					System.out.println("Error: Fuera de Rango");
    					break;
            }
        }while(opc!=9);       
    }
    private static void salir() {
    	System.out.println("Gracias por su visita ... ");
    }
    private static void sumar() throws IOException {
    	saltodelinea(2);
    	System.out.println("------------------------------");
    	System.out.println("| SUMATORIA DE MATRIZ A + B: |");
    	System.out.println("------------------------------");
    	saltodelinea(1);
        if(fila==fila2 && colum==colum2)
        {        
        for( int x=0;x< fila;x++)
        {
            for( int y=0;y < colum;y++)
            {
                System.out.print((m1[x][y])+(m2[x][y])+" , ");                
            }   
           // System.out.print("n");
        }
 
        }else{
            System.out.print("NO se pude sumar las matrices " );
        }
    }
 
    private static void matriz1() throws IOException {
    	saltodelinea(2);
    	System.out.println("------------- MATRIZ A ------------");
        System.out.print("Tamaño de FILAS: " );
        fila=Integer.parseInt( entrada.readLine());
        System.out.print("Tamaño de COLUMNAS: " );
        colum=Integer.parseInt( entrada.readLine());
        m1= new double [fila][colum];
        saltodelinea(1);
        
        for(int i=0;i<fila;i++){
            for(int j=0;j<colum;j++){
                System.out.print("Valor de matriz en ["+(i+1)+" , "+(j+1)+" ]= " );
                m1[i][j]=Double.parseDouble( entrada.readLine());
            }            
        }
    }
 
    private static void matriz2() throws IOException {
    	saltodelinea(2);
    	System.out.println("------------- MATRIZ B ------------");
    	System.out.print("Tamaño de FILAS: " );
        fila2=Integer.parseInt( entrada.readLine());
        System.out.print("Tamaño de COLUMNAS: " );
        colum2=Integer.parseInt( entrada.readLine());
        m2= new double [fila2][colum2];
        saltodelinea(1);
        for(int i=0;i< fila2;i++){
            for(int j=0;j < colum2;j++){
                System.out.print("valor de matriz en ["+i+1+" , "+(j+1)+" ]= " );
                m2[i][j]=Double.parseDouble( entrada.readLine());
            }            
        }
    }
 
    private static void sumar2() {
        if(fila==fila2 && colum==colum2)
        {                
        for( int x=0;x<fila;x++)
        {
            for( int y=0;y<colum;y++)
            {
                System.out.print((m1[x][y])+(m2[x][y])+" , ");                
            }   
            System.out.print("n");
        }
 
        }else{
            System.out.print("no se pude sumar las matrices " );
        }
    }
 
    private static void restar() {
    	saltodelinea(2);
    	System.out.println("--------------------------");
    	System.out.println("| RESTA DE MATRIZ A - B: |");
    	System.out.println("--------------------------");
    	saltodelinea(1);
        if(fila==fila2 && colum==colum2)
        {        
        for( int x=0;x<fila;x++)
        {
            for( int y=0;y<colum;y++)
            {
                System.out.print((m1[x][y])-(m2[x][y])+" , ");                
            }   
            //System.out.print("n");
        }        
        }else{
            System.out.print("no se pude restar las matrices " );
        }
    }
 
    private static void restar2() {
        if(fila==fila2 && colum==colum2)
        {        
        for( int x=0;x<fila;x++)
        {
            for( int y=0;y<colum;y++)
            {
                System.out.print((m2[x][y])-(m1[x][y])+" , ");                
            }   
           // System.out.print("n");
        }        
        }else{
            System.out.print("no se pude sumar las matrices " );
        }
    }
 
    private static void multi() throws IOException {
    	saltodelinea(2);
    	System.out.println("----------------------------------");
    	System.out.println("| MULTIPLICACION DE MATRIZ A * B |");
    	System.out.println("----------------------------------");
    	saltodelinea(1); 
        if(colum==fila2)
        {        
            double [][] r1=new double[fila][colum2];
            for(int x=0;x<fila;x++)
            {
                for(int y=0;y<colum2;y++)
                {
                    for(int m=0;m<colum;m++)
                    {
                        r1[x][y]+=m1[x][m]*m2[m][y];
                    }
                    System.out.print(r1[x][y]+" , ");                
                }
                //System.out.print("n");
            }                
        }else{
            System.out.print("No se puede multiplicar matrices");
            String a=entrada.readLine();
        }
    }
 
    private static void multi2() throws IOException {
        if(colum2==fila)
        {        
            double [][] r1=new double[fila2][colum];
            for(int x=0;x<fila2;x++)
            {
                for(int y=0;y<colum;y++)
                {
                    for(int m=0;m< colum2;m++)
                    {
                        r1[x][y]+=m2[x][m]*m1[m][y];
                    }
                    System.out.print(r1[x][y]+" , ");                
                }
                System.out.print("n");
            }                
        }else{
            System.out.print("No se puede multiplicar matrices");
            String a=entrada.readLine();
        }
    }
 
    private static void deta() throws IOException {
        if(fila==colum){  
        	saltodelinea(2);
            System.out.println("La DETERMINANTE es : "+determinante(m1));
            System.out.println("--------------------------");
            String a=entrada.readLine();
        }else{
            System.out.print("La Matriz no tiene determinante");
            String a=entrada.readLine();
        }
    }
 
    public static double determinante(double[][] matriz){
        double det;
        if(matriz.length==2){
            det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
            return det;
        }
        double suma=0;
        for(int i=0; i<matriz.length; i++){
        double[][] nm=new double[matriz.length-1][matriz.length-1];
            for(int j=0; j<matriz.length; j++){
                if(j!=i){
                    for(int k=1; k<matriz.length; k++){
                    int indice=-1;
                    if(j<i)
                    indice=j;
                    else if(j>i)
                    indice=j-1;
                    nm[indice][k-1]=matriz[j][k];
                    }
                }
            }
            if(i%2==0)
            suma+=matriz[i][0] * determinante(nm);
            else
            suma-=matriz[i][0] * determinante(nm);
        }
        return suma;
    }
 
    @SuppressWarnings("unused")
	private static void detb() throws IOException {
        if(fila2==colum2){            
            System.out.print("La determinante es : "+determinante(m2));        
            String a=entrada.readLine();
        }else{
            System.out.print("La Matriz NO tiene determinante");
            String a=entrada.readLine();
        }
    }
 
    private static void traa() throws IOException {    
    	saltodelinea(2);
        System.out.println("LA MATRIZ ORIGINAL ");
        System.out.println("-------------------");
        saltodelinea(1);
        //System.out.print("n");
        for(int x=0;x<fila;x++)
        {
            for(int y=0;y<colum;y++)
            {
                System.out.print(m1[x][y]+ " , ");     
            }   
           // System.out.print("n");
        }
        // System.out.print("nn");
        saltodelinea(2);
        System.out.println("LA MATRIZ TRANSPUESTA ");
        System.out.println("----------------------");
        saltodelinea(1);
        //System.out.print("n");
        for(int x=0;x<colum;x++)
        {
            for(int y=0;y<fila;y++)
            {
                System.out.print(m1[y][x]+ " , ");     
            }   
           //System.out.print("n");
        }        
        String a=entrada.readLine();
    }
 
    private static void trab() throws IOException {
        System.out.print("La matriz original");
        System.out.print("n");
        for(int x=0;x<fila2;x++)
        {
            for(int y=0;y<colum2;y++)
            {
                System.out.print(m2[x][y]+ " , ");     
            }   
            System.out.print("n");
        }
        System.out.print("nn");
        System.out.print("La matriz transpuesta");
        System.out.print("n");
        for(int x=0;x<colum2;x++)
        {
            for(int y=0;y<fila2;y++)
            {
                System.out.print(m2[y][x]+ " , ");     
            }   
            System.out.print("n");
        }        
        String a=entrada.readLine();
    }
 
    private static void inva() throws IOException {     
    	saltodelinea(2);
    	System.out.println("------------- INVERSA DE A^ -1 -----------");
        if(fila==colum && determinante(m1)!=0){
            double[][] res = matrizInversa(m1);
            for(int i=0;i<res.length ; i++){
                for(int j=0;j<res.length;j++){
                    System.out.print( ((res[i][j]*100)/100)+" , ");
                }
               // System.out.print("n");
            }
            String a=entrada.readLine();
        }else{
            System.out.println("NO tiene inversa");
            String a=entrada.readLine();
        }
    }
 
    private static void invb() throws IOException {
        if(fila2==colum2 && determinante(m1)!=0){
            double[][] res = matrizInversa(m2);
            for(int i=0;i<res.length ; i++){
                for(int j=0;j<res.length;j++){
                    System.out.print(((res[i][j]*100)/100)+" , ");
                }
                System.out.print("n");
            }
            String a=entrada.readLine();
        }else{
            System.out.println("La matriz no tiene inversa");
            String a=entrada.readLine();
        }
    }
 
    public static double[][] matrizInversa(double[][] matriz) {
        double det=1/determinante(matriz);
        double[][] nmatriz=matrizAdjunta(matriz);
        multiplicarMatriz(det,nmatriz);
        return nmatriz;
    }
 
    public static void multiplicarMatriz(double n, double[][] matriz) {
        for(int i=0;i<matriz.length;i++)
        for(int j=0;j<matriz.length;j++)
        matriz[i][j]*=n;
    }
 
    public static double[][] matrizAdjunta(double [][] matriz){
        return matrizTranspuesta(matrizCofactores(matriz));
    }
 
    public static double[][] matrizCofactores(double[][] matriz){
        double[][] nm=new double[matriz.length][matriz.length];
        for(int i=0;i<matriz.length;i++) {
            for(int j=0;j<matriz.length;j++) {
                double[][] det=new double[matriz.length-1][matriz.length-1];        
                double detValor;
                for(int k=0;k<matriz.length;k++) {
                    if(k!=i) {
                        for(int l=0;l<matriz.length;l++) {
                            if(l!=j) {
                            int indice1=k<i ? k : k-1 ;
                            int indice2=l<j ? l : l-1 ;
                            det[indice1][indice2]=matriz[k][l];
                            }
                        }
                    }
                }
                detValor=determinante(det);
                nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
            }
        }
        return nm;
    }
 
    public static double[][] matrizTranspuesta(double [][] matriz){
        double[][]nuevam=new double[matriz[0].length][matriz.length];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++)
                nuevam[i][j]=matriz[j][i];
        }
        return nuevam;
    }
}
