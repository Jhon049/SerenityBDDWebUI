Feature: Contacto a soporte
  yo como automatizador de pruebas
  quiero realizar el contacto a soporte
  para validar el funcionamiento del modulo

  Scenario: Contacto con servicio al cliente
    Given me encuentro en el modulo de contact us
    When diligencio el formulario
    Then se confirma el envio

