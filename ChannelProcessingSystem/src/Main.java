import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    double m = 2.0;
    double c = 0.5;
    double[] X = {
      0.814723686393179,
      0.905791937075619,
      0.126986816293506,
      0.913375856139019,
      0.63235924622541,
      0.0975404049994095,
      0.278498218867048,
      0.546881519204984,
      0.957506835434298,
      0.964888535199277,
      0.157613081677548,
      0.970592781760616,
      0.957166948242946,
      0.485375648722841,
      0.8002804688888,
      0.141886338627215,
      0.421761282626275,
      0.915735525189067,
      0.792207329559554,
      0.959492426392903,
      0.655740699156587,
      0.0357116785741896,
      0.849129305868777,
      0.933993247757551,
      0.678735154857773,
      0.757740130578333,
      0.743132468124916,
      0.392227019534168,
      0.655477890177557,
      0.171186687811562,
      0.706046088019609,
      0.0318328463774207,
      0.27692298496089,
      0.0461713906311539,
      0.0971317812358475,
      0.823457828327293,
      0.694828622975817,
      0.317099480060861,
      0.950222048838355,
      0.0344460805029088,
      0.438744359656398,
      0.381558457093008,
      0.765516788149002,
      0.795199901137063,
      0.186872604554379,
      0.489764395788231,
      0.445586200710899,
      0.646313010111265,
      0.709364830858073,
      0.754686681982361,
      0.276025076998578,
      0.679702676853675,
      0.655098003973841,
      0.162611735194631,
      0.118997681558377,
      0.498364051982143,
      0.959743958516081,
      0.340385726666133,
      0.585267750979777,
      0.223811939491137,
      0.751267059305653,
      0.255095115459269,
      0.505957051665142,
      0.699076722656686,
      0.890903252535799,
      0.959291425205444,
      0.547215529963803,
      0.138624442828679,
      0.149294005559057,
      0.257508254123736,
      0.840717255983663,
      0.254282178971531,
      0.814284826068816,
      0.243524968724989,
      0.929263623187228,
      0.349983765984809,
      0.196595250431208,
      0.251083857976031,
      0.616044676146639,
      0.473288848902729,
      0.351659507062997,
      0.830828627896291,
      0.585264091152724,
      0.54972360829114,
      0.91719366382981,
      0.285839018820374,
      0.757200229110721,
      0.753729094278495,
      0.380445846975357,
      0.567821640725221,
      0.0758542895630636,
      0.0539501186666072,
      0.530797553008973,
      0.779167230102011,
      0.934010684229183,
      0.12990620847373,
      0.568823660872193,
      0.469390641058206,
      0.0119020695012414,
      0.337122644398882
    };
    Function1(m, c, X); //Function1 is Y=mX+c here I have called the function to run first
    double b = Function2(); //Function2 is B=A+Y and b=mean(B)
    b = Math.round(b); //I rounded the number down to 1 decimal place, I done this because m is 1 decimal place this can be changed
    System.out.println("b = " + b); //Printing out b
    Function3(X); //Function3 is A=1/X
    Function4(X, b); //Function4 is C=X+b here I have passed value b through this function to produce result of C
  }

  public static void Function1(double x, double y, double[] X) throws FileNotFoundException {
    //Here I am taking m(2.0) and multiplying it with each element of array X then adding c(0.5) to each element
    //Text files are good in this scenario because if I only know the Y value I can assign it to a text file manually and use it
    //Furthermore, generating the results to a file allow me to pull the file in other functions and create a new array with them
    //Please note that the printout functions are for testing purposes to ensure data was getting generated
    PrintWriter outputFile = new PrintWriter("ValueY.txt");
    //System.out.println("Y =");
    for (int i = 0; i < X.length; i++) {
      //System.out.println(x * X[i] + y + " ");
      outputFile.println(x * X[i] + y);
    }
    outputFile.close();
  }

  public static double Function2() throws FileNotFoundException {
    //Please note all the print functions are for testing to ensure data was getting generated
    //B = A + Y
    //b = mean(B)
    //Here I have taken what is stored in ValueA.txt file (Generated from Function3) and stored it into array A 
    Scanner scanner = new Scanner(new File("ValueA.txt"));
    double[] A = new double[100];
    int i = 0;
    while (scanner.hasNextDouble()) {
      A[i++] = scanner.nextDouble(); //Here I am storing the data to Array A
    }
    for (int j = 0; j < A.length; j++) {
      //System.out.println(A[j] + " ");
    }
    //Here I have taken data which is stored in ValueY.txt file (Generated from Function1) and stored it into array Y
    Scanner scanner1 = new Scanner(new File("ValueY.txt"));
    double[] Y = new double[100];
    int p = 0;
    while (scanner1.hasNextDouble()) {
      Y[p++] = scanner1.nextDouble(); //Here I am storing the data to Array Y
    }
    for (int q = 0; q < Y.length; q++) {
      //System.out.println(Y[q] + " ");
    }
    // Here I have added the individual elements of both arrays (A and Y) together to generate array B
    double[] B = new double[A.length];
    for (int v = 0; v <= A.length - 1; v++) {
      B[v] = A[v] + Y[v]; //ADDING
    }
    //System.out.println("SUM OF TWO ARRY");
    for (int j = 0; j <= B.length - 1; j++) {
      //System.out.println(B[j]);
    }
    //This function is to Work out mean value of array B to get value of b
    double sum = 0;
    for (int x = 0; x < B.length; x++) {
      sum += B[x];
    }
    //System.out.println("b = " + sum/B.length);
    return sum / B.length; //Using a return statement I was able to store the result into b and use it for Function4
  }

  public static void Function3(double[] X) throws FileNotFoundException {
    //For this method, I have taken the number 1 and divided it by each element of array X
	//Text files are good in this scenario because if I only know the A value I can assign it to a text file manually and use it
	//Furthermore, generating the results to a file allow me to pull the file in other functions and create a new array with them
	//Please note that the printout functions are for testing purposes to ensure data was getting generated
    PrintWriter outputFile = new PrintWriter("ValueA.txt");
    //System.out.println("A =");
    for (int i = 0; i < X.length; i++) {
      //System.out.print(1/X[i] + " ");
      outputFile.println(1 / X[i]);
    }
    outputFile.close();
  }

  public static void Function4(double[] X, double z) throws FileNotFoundException {
    //This function is taking each element of array X and adding the value of b to it
	//Text files are good in this scenario because if I only know the C value I can assign it to a text file manually and use it
	//Furthermore, generating the results to a file allow me to pull the file in other functions and create a new array with them
	//Please note that the printout functions are for testing purposes to ensure data was getting generated
    PrintWriter outputFile = new PrintWriter("ValueC.txt");
    //System.out.println("C =");
    for (int i = 0; i < X.length; i++) {
      //System.out.println(X[i] + z + " ");
      outputFile.println(X[i] + z);
    }
    outputFile.close();
  }
}