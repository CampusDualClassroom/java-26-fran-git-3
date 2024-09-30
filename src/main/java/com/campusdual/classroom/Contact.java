package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode();
    }

    private String generateCode() {
        // Normalizar el nombre y apellidos, eliminando acentos y convirtiendo a minúsculas
        String normalizedName = Normalizer.normalize(name, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();
        String normalizedSurnames = Normalizer.normalize(surnames, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toLowerCase();

        // Dividir los apellidos en partes
        String[] surnameParts = normalizedSurnames.split(" ");

        // Crear el código
        StringBuilder codeBuilder = new StringBuilder();

        // Agregar la primera letra del primer nombre
        if (normalizedName.length() > 0) {
            codeBuilder.append(normalizedName.charAt(0)); // Primera letra del nombre
        }

        // Agregar el primer apellido
        if (surnameParts.length == 1) {
            // Solo un apellido
            codeBuilder.append(surnameParts[0]); // Agregar el apellido completo
        } else if (surnameParts.length > 1) {
            // Más de un apellido
            String firstSurname = surnameParts[0]; // Primer apellido
            StringBuilder secondSurnameBuilder = new StringBuilder();

            // Concatenar el segundo apellido, eliminando espacios
            for (int i = 1; i < surnameParts.length; i++) {
                secondSurnameBuilder.append(surnameParts[i]);
            }

            // Agregar la primera letra del primer apellido
            codeBuilder.append(firstSurname.charAt(0)); // Primera letra del primer apellido
            // Agregar el segundo apellido completo (junto y en minúsculas)
            codeBuilder.append(secondSurnameBuilder.toString().toLowerCase());
        }

        // Retornar el código generado
        return codeBuilder.toString(); // Retorna el código en el formato correcto
    }











    // Métodos de la interfaz ICallActions
    @Override
    public void callMyNumber() {
        System.out.println("Llamando a " + name + " " + surnames + " al número " + phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando a " + number + " desde " + name + " " + surnames);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + name + " " + surnames);
        System.out.println("Número de teléfono: " + phone);
        System.out.println("Código: " + code);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }
}
