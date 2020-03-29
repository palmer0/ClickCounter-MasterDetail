Feature: pantalla maestro

  Scenario: crear nuevo contador en maestro
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "numero"
    When pulsamos boton master
    Then incluiremos nuevo contador en lista en posicion "posicion"
    And mostraremos contador con valor "valor"

  Scenario: pulsar en contador de maestro
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "numero"
    When pulsamos boton contador en posicion "posicion"
    Then iniciaremos pantalla detalle
    And mostraremos contador con valor "valor"
    And mostraremos numero de clicks con valor "valor"

  Scenario: pulsar en contador de detalle
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "numero"
    And pulsando boton contador en posicion "posicion"
    And iniciando pantalla detalle
    And mostrando contador con valor "valor"
    And mostrando numero de clicks con valor "valor"
    When pulsamos boton detalle
    Then mostraremos contador con valor "valor"
    And mostraremos numero de clicks con valor "valor"

  Scenario: pulsar en regresar de detalle
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "numero"
    And pulsando boton contador en posicion "posicion"
    And iniciando pantalla detalle
    And mostrando contador con valor "valor"
    And mostrando numero de clicks con valor "valor"
    And pulsando boton detalle
    When pulsamos boton regresar
    Then finalizaremos pantalla detalle
    And resumiremos pantalla maestro
    And mostraremos contador con valor "valor"
    And mostraremos numero de clicks con valor "valor"