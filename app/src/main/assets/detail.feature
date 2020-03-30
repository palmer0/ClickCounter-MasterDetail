Feature: pantalla detalle

  Scenario: pulsar en contador de detalle
    Given iniciando pantalla detalle
    And mostrando contador con valor "2"
    And mostrando numero de clicks con valor "3"
    When pulsamos boton detalle
    Then mostraremos contador con valor "3"
    And mostraremos numero de clicks con valor "4"