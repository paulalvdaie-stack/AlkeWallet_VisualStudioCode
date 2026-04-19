package com.alkemy.wallet;

import com.alkemy.wallet.model.Cuenta;
import com.alkemy.wallet.model.CuentaImpl;
import com.alkemy.wallet.service.ConversionMoneda;
import com.alkemy.wallet.util.TipoMoneda;

import java.util.Scanner;

/**
 * Clase principal de la aplicación Alke Wallet
 * Billetera digital para gestionar activos financieros
 * 
 * @author Alkemy Digital
 * @version 1.0
 */
public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Cuenta cuenta = null;
    
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("    BIENVENIDO A ALKE WALLET");
        System.out.println("    Tu billetera digital segura");
        System.out.println("===========================================\n");
        
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> verSaldo();
                case 3 -> depositarDinero();
                case 4 -> retirarDinero();
                case 5 -> convertirMoneda();
                case 6 -> {
                    System.out.println("\n¡Gracias por usar Alke Wallet! 👋");
                    continuar = false;
                }
                default -> System.out.println("\n❌ Opción inválida. Intente nuevamente.\n");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal de opciones
     */
    private static void mostrarMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          MENÚ PRINCIPAL                ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Crear cuenta                        ║");
        System.out.println("║ 2. Ver saldo                           ║");
        System.out.println("║ 3. Depositar dinero                    ║");
        System.out.println("║ 4. Retirar dinero                      ║");
        System.out.println("║ 5. Convertir moneda                    ║");
        System.out.println("║ 6. Salir                               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Lee la opción ingresada por el usuario
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Crea una nueva cuenta de wallet
     */
    private static void crearCuenta() {
        System.out.println("\n--- CREAR NUEVA CUENTA ---");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.println("\nSeleccione el tipo de moneda:");
        System.out.println("1. Peso Chileno (CLP)");
        System.out.println("2. Dólar (USD)");
        System.out.println("3. Euro (EUR)");
        System.out.print("Opción: ");
        
        int opcionMoneda = leerOpcion();
        TipoMoneda moneda;
        
        moneda = switch (opcionMoneda) {
            case 1 -> TipoMoneda.CLP;
            case 2 -> TipoMoneda.USD;
            case 3 -> TipoMoneda.EUR;
            default -> TipoMoneda.CLP;
        };
        
        cuenta = new CuentaImpl(nombre, moneda);
        System.out.println("\n✅ Cuenta creada exitosamente!");
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Moneda: " + cuenta.getMoneda());
        System.out.println("Saldo inicial: " + cuenta.consultarSaldo() + "\n");
    }
    
    /**
     * Muestra el saldo actual de la cuenta
     */
    private static void verSaldo() {
        if (!validarCuenta()) return;
        
        System.out.println("\n--- SALDO ACTUAL ---");
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo: " + cuenta.getMoneda() + " " + 
                         String.format("%.2f", cuenta.consultarSaldo()));
        System.out.println();
    }
    
    /**
     * Permite depositar dinero en la cuenta
     */
    private static void depositarDinero() {
        if (!validarCuenta()) return;
        
        System.out.println("\n--- DEPOSITAR DINERO ---");
        System.out.print("Ingrese el monto a depositar: ");
        
        try {
            double monto = Double.parseDouble(scanner.nextLine());
            cuenta.depositar(monto);
            System.out.println("✅ Depósito realizado exitosamente!");
            System.out.println("Nuevo saldo: " + cuenta.getMoneda() + " " + 
                             String.format("%.2f", cuenta.consultarSaldo()) + "\n");
        } catch (NumberFormatException e) {
            System.out.println("❌ Monto inválido.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage() + "\n");
        }
    }
    
    /**
     * Permite retirar dinero de la cuenta
     */
    private static void retirarDinero() {
        if (!validarCuenta()) return;
        
        System.out.println("\n--- RETIRAR DINERO ---");
        System.out.println("Saldo disponible: " + cuenta.getMoneda() + " " + 
                         String.format("%.2f", cuenta.consultarSaldo()));
        System.out.print("Ingrese el monto a retirar: ");
        
        try {
            double monto = Double.parseDouble(scanner.nextLine());
            cuenta.retirar(monto);
            System.out.println("✅ Retiro realizado exitosamente!");
            System.out.println("Nuevo saldo: " + cuenta.getMoneda() + " " + 
                             String.format("%.2f", cuenta.consultarSaldo()) + "\n");
        } catch (NumberFormatException e) {
            System.out.println("❌ Monto inválido.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage() + "\n");
        }
    }
    
    /**
     * Permite convertir el saldo a otra moneda
     */
    private static void convertirMoneda() {
        if (!validarCuenta()) return;
        
        System.out.println("\n--- CONVERSIÓN DE MONEDA ---");
        System.out.println("Saldo actual: " + cuenta.getMoneda() + " " + 
                         String.format("%.2f", cuenta.consultarSaldo()));
        
        System.out.println("\nSeleccione la moneda destino:");
        System.out.println("1. Peso Chileno (CLP)");
        System.out.println("2. Dólar (USD)");
        System.out.println("3. Euro (EUR)");
        System.out.print("Opción: ");
        
        int opcion = leerOpcion();
        TipoMoneda monedaDestino;
        
        monedaDestino = switch (opcion) {
            case 1 -> TipoMoneda.CLP;
            case 2 -> TipoMoneda.USD;
            case 3 -> TipoMoneda.EUR;
            default -> {
                System.out.println("❌ Opción inválida.\n");
                yield null;
            }
        };
        
        if (monedaDestino != null) {
            if (monedaDestino == cuenta.getMoneda()) {
                System.out.println("❌ La cuenta ya está en " + monedaDestino + "\n");
                return;
            }
            
            double saldoAnterior = cuenta.consultarSaldo();
            TipoMoneda monedaAnterior = cuenta.getMoneda();
            
            double nuevoSaldo = ConversionMoneda.convertir(
                saldoAnterior, 
                cuenta.getMoneda(), 
                monedaDestino
            );
            
            cuenta.setMoneda(monedaDestino);
            cuenta.setSaldo(nuevoSaldo);
            
            System.out.println("\n✅ Conversión realizada exitosamente!");
            System.out.println("Saldo anterior: " + monedaAnterior + " " + 
                             String.format("%.2f", saldoAnterior));
            System.out.println("Nuevo saldo: " + monedaDestino + " " + 
                             String.format("%.2f", nuevoSaldo) + "\n");
        }
    }
    
    /**
     * Valida que exista una cuenta creada
     */
    private static boolean validarCuenta() {
        if (cuenta == null) {
            System.out.println("\n❌ Debe crear una cuenta primero.\n");
            return false;
        }
        return true;
    }
}
