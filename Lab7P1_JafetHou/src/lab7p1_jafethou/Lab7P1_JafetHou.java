
import java.util.Scanner;
import java.util.Random;

public class Lab7P1_JafetHou {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. She shoot, she scores!");
            System.out.println("2. Piedra, papel o ...");
            System.out.println("3. Ingrese 3 para salir");
            System.out.println("Ingrese la opcion:");
            int OPC = leer.nextInt();

            switch (OPC) {
                case 1:
                    System.out.println("Ingrese el tamano de filas: ");
                    int filas = leer.nextInt();

                    System.out.println("Ingrese la cantidad de columnas: ");
                    int colum = leer.nextInt();

                    int[][] num = new int[filas][colum];
                    num = visual(filas, colum);
                    int num2 = suma(num, filas, colum);
                    break;

                case 2:
                    System.out.println("“Scissors cuts paper, paper covers rock, rock crushes lizard, lizard poisons Spock, Spock smashes");
                    System.out.println("scissors, scissors decapitates lizard, lizard eats paper, paper disproves Spock, Spock vaporizes rock,");
                    System.out.println("and as it always has, rock crushes scissors.”");
                    System.out.println("1. Tijeras");
                    System.out.println("2. Papel");
                    System.out.println("3. Piedra");
                    System.out.println("4. Lagarto");
                    System.out.println("5. Spock");
                    System.out.println("Ingrese su opcion:");
                    int elec = leer.nextInt();

                    int[] num1 = new int[elec];
                    num1 = maquina(elec);
                    break;

                case 3:
                    continuar = false;
                    break;
            }
        }
    }

    public static int[][] visual(int f, int c) {
        int[][] temporal = new int[f][c];
        int max = f * c;

        if (max > 88) {
            System.out.println("El numero multiplicado de filas y numeros debe ser menor a 88.");
        } else {
            boolean[] numerosUtilizados = new boolean[max + 1];

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    int num;

                    do {
                        num = 1 + ran.nextInt(max);
                    } while (numerosUtilizados[num]);

                    numerosUtilizados[num] = true;
                    temporal[i][j] = num;
                }
            }
        }

        return temporal;
    }

    public static String print(int[][] matriz) {
        String mostrar = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                mostrar += matriz[i][j] + "\t";
            }

            mostrar += "\n";
        }

        return mostrar;
    }

    public static int suma(int[][] matriz, int f, int c) {
        int acum1 = 0;
        int jugador = 1;
        int jug1 = 99;
        int jug2 = 88;
        int acum2 = 0;
        System.out.println("Ingrese la cantidad de balas: ");
        int balas = leer.nextInt();
        int balas2 = balas;

        while (balas != 0 && balas2 != 0) {
            if (jugador == 1) {
                boolean encontrar = false;
                System.out.println("\n---TABLERO PARA JUGAR---");
                System.out.println(print(matriz));
                System.out.println("Elige que numero disparar Jugador " + jugador);
                int disparo = leer.nextInt();

                for (int i = 0; i < f; i++) {
                    for (int j = 0; j < c; j++) {
                        if (disparo == matriz[i][j] && disparo != 99 && disparo != 88) {
                            System.out.println("tiro acertado");
                            matriz[i][j] = jug1;
                            acum1 += disparo;
                            System.out.println(print(matriz));

                            encontrar = true;
                            break;
                        }
                    }
                }

                if (!encontrar) {
                    System.out.println(print(matriz));
                    System.out.println("Fallo tiro");
                }
            }

            boolean encon = false;
            balas--;
            System.out.println("Quedan " + balas + " balas");
            jugador++;

            if (jugador == 2) {
                encon = false;
                System.out.println("\n---TABLERO PARA JUGAR---");
                System.out.println(print(matriz));
                System.out.println("Elige que numero disparar Jugador " + jugador);
                int disparo = leer.nextInt();

                for (int i = 0; i < f; i++) {
                    for (int j = 0; j < c; j++) {
                        if (disparo == matriz[i][j] && disparo != 99 && disparo != 88) {
                            System.out.println("tiro acertado");
                            matriz[i][j] = jug2;
                            acum2 += disparo;
                            System.out.println(print(matriz));
                            encon = true;
                            break;
                        }
                    }
                }
            }

            if (!encon) {
                System.out.println(print(matriz));
                System.out.println("Fallo tiro");
            }

            balas2--;
            System.out.println("Quedan " + balas + " balas");
            jugador--;
        }

        if (acum1 < acum2) {
            System.out.println("Jugador 2 gana con " + acum2);
            System.out.println("Jugador 1 pierde con " + acum1);
        } else {
            System.out.println("Jugador 1 gana con " + acum1);
            System.out.println("Jugador 2 pierde con " + acum2);
        }

        return acum1;
    }

    public static int[] maquina(int eleccion) {
        int[] maquina = new int[1];
        int[] temporal = new int[5];

        maquina[0] = 1 + ran.nextInt(5);

        if (maquina[0] == 1) {
            System.out.println("La maquina eligio Tijeras");
            if (eleccion == 1) {
                System.out.println("El resultado es: Empate");
            } else if (eleccion == 2 || eleccion == 4) {
                System.out.println("La maquina gana ");
            } else if (eleccion == 3 || eleccion == 5) {
                System.out.println("Jugador gana ");
            } else {
                System.out.println("No eligio opcion correcta");
            }
        } else if (maquina[0] == 2) {
            System.out.println("La maquina eligio Papel");
            if (eleccion == 2) {
                System.out.println("El resultado es: Empate");
            } else if (eleccion == 3 || eleccion == 5) {
                System.out.println("La maquina gana ");
            } else if (eleccion == 1 || eleccion == 4) {
                System.out.println("Jugador gana ");
            } else {
                System.out.println("No eligio opcion correcta");
            }
        } else if (maquina[0] == 3) {
            System.out.println("La maquina eligio Piedra");
            if (eleccion == 3) {
                System.out.println("El resultado es: Empate");
            } else if (eleccion == 1 || eleccion == 4) {
                System.out.println("La maquina gana ");
            } else if (eleccion == 5 || eleccion == 2) {
                System.out.println("Jugador gana ");
            } else {
                System.out.println("No eligio opcion correcta");
            }
        } else if (maquina[0] == 4) {
            System.out.println("La maquina eligio Papel");
            if (eleccion == 4) {
                System.out.println("El resultado es: Empate");
            } else if (eleccion == 5 || eleccion == 2) {
                System.out.println("La maquina gana ");
            } else if (eleccion == 1 || eleccion == 3) {
                System.out.println("Jugador gana ");
            } else {
                System.out.println("No eligio opcion correcta");
            }
        } else if (maquina[0] == 5) {
            System.out.println("La maquina eligio Papel");
            if (eleccion == 5) {
                System.out.println("El resultado es: Empate");
            } else if (eleccion == 2 || eleccion == 4) {
                System.out.println("La maquina gana ");
            } else if (eleccion == 1 || eleccion == 3) {
                System.out.println("Jugador gana ");
            } else {
                System.out.println("No eligio opcion correcta");
            }
        }
        System.out.println("");

        return maquina;
    }
}
