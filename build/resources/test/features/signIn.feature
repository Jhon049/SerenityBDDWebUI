Feature: ingreso a cuenta
  yo como automatizador de pruebas
  quiero realizar el ingreso a cuenta registrada
  para validar el funcionamiento del modulo

  Scenario: Ingreso a cuenta de usuario
    Given ingreso a sign in
    When diligencio las credenciales
    Then ingreso al perfil del usuario

    @dos
  Scenario: Ingreso fallido a cuenta de usuario
    Given ingreso a modulo
    When diligencio las credenciales incorrectas
    Then se valida error en ingreso