Feature: Registrar cuenta nueva
  yo como automatizador de pruebas
  quiero registrar una cuenta nueva
  para validar el funcionamiento del modulo

  @uno
  Scenario: Registrar nuevo cliente
    Given me encuentro en el modulo sign in
    When diligencio el correo a registrar
    And diligencio el formulario de registro
    Then se valida la creacion de la cuenta

    @dos
  Scenario: Registro fallido
    Given ingreso al modulo sign in
    When dejo el correo en blanco
    Then se valida el error generado