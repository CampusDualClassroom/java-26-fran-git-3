package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menú:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    // Añadir contacto
                    System.out.print("Introduce el nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Introduce los apellidos: ");
                    String surnames = scanner.nextLine();
                    System.out.print("Introduce el número de teléfono: ");
                    String phone = scanner.nextLine();
                    Contact newContact = new Contact(name, surnames, phone);
                    phonebook.addContact(newContact);
                    System.out.println("Contacto añadido.");
                    System.out.println(newContact.getCode());
                    break;

                case 2:
                    // Mostrar contactos
                    System.out.println("###TODOS LOS CONTACTOS###");
                    phonebook.showPhonebook();
                    break;

                case 3:
                    // Seleccionar contacto
                    System.out.println("###TODOS LOS CONTACTOS###");
                    phonebook.showPhonebook();
                    System.out.print("Introduce el código del contacto: ");
                    String code = scanner.nextLine();
                    Contact selectedContact = phonebook.getData().get(code);
                    if (selectedContact != null) {
                        // Aquí puedes llamar a un menú adicional para el contacto
                        boolean contactMenu = true;
                        while (contactMenu) {
                            System.out.println("###"+(selectedContact.getName())+"###");
                            System.out.println("Menú del contacto:");
                            System.out.println("1. Llamar a mi número");
                            System.out.println("2. Llamar a otro número");
                            System.out.println("3. Mostrar detalles del contacto");
                            System.out.println("4. Volver");
                            System.out.print("Elige una opción: ");
                            int contactOption = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer1

                            switch (contactOption) {
                                case 1:
                                    selectedContact.callMyNumber();
                                    break;
                                case 2:
                                    System.out.print("Introduce el número a llamar: ");
                                    String otherNumber = scanner.nextLine();
                                    selectedContact.callOtherNumber(otherNumber);
                                    break;
                                case 3:
                                    System.out.println("###"+(selectedContact.getName())+"###");
                                    selectedContact.showContactDetails();
                                    break;
                                case 4:
                                    contactMenu = false;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                        }
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    // Eliminar contacto
                    System.out.print("Introduce el código del contacto a eliminar: ");
                    String codeToDelete = scanner.nextLine();
                    phonebook.deleteContact(codeToDelete);
                    System.out.println("Contacto eliminado.");
                    break;

                case 5:
                    // Salir
                    running = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}
