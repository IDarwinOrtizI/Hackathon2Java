package model;
//  Logica de la lista, añadir, buscar, borrar...
public class Agenda {
    private Contacto[] contactos;

    //indicar el tamaño maximo
    package com.example.hackathon2fxjava.model;

import java.util.Arrays;
import java.util.Comparator;

    public class Agenda {

        private Contacto[] contactos;

        public Agenda(int capacidad) {
            contactos = new Contacto[capacidad];
        }

        public Agenda() {
            this(10);
        }
//        añadirContacto(Contacto c):

        public void añadirContacto(Contacto c) {

            if (c == null) {
                throw new IllegalArgumentException("El contacto no puede ser nulo");
            }

            if (c.getNombre().trim().isEmpty() || c.getApellido().trim().isEmpty()) {
                throw new IllegalArgumentException("Nombre y apellido no pueden estar vacíos");
            }
//            existeContacto(Conctacto c):

            public boolean existeContacto(Contacto c) {
                for (Contacto actual : contactos) {
                    if (actual != null &&
                            actual.getNombre().equalsIgnoreCase(c.getNombre()) &&
                            actual.getApellido().equalsIgnoreCase(c.getApellido())) {
                        return true;
                    }
                }
                return false;
            }

//            listarContactos():


            public String[] listarContactos() {
                return Arrays.stream(contactos)
                        .filter(c -> c != null)
                        .sorted(Comparator
                                .comparing(Contacto::getNombre)
                                .thenComparing(Contacto::getApellido))
                        .map(c -> c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono())
                        .toArray(String[]::new);
            }