Feature: pantalla maestro

  Scenario: crear contador en maestro
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "0"
    When pulsamos boton master
    Then mostraremos contador en lista en posicion "0" con valor "0"
    And mostraremos lista con numero de contadores "1"

  Scenario: crear contador en maestro girando pantalla
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "0"
    And pulsando boton master
    When rotamos pantalla
    Then mostraremos contador en lista en posicion "0" con valor "0"
    And mostraremos lista con numero de contadores "1"


  Scenario: pulsar en contador de maestro
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "0"
    And pulsando boton master
    And mostrando contador en lista en posicion "0" con valor "0"
    And mostrando lista con numero de contadores "1"
    When pulsamos boton contador en posicion "0"
    Then iniciaremos pantalla detalle
    And mostraremos contador con valor "1"
    And mostraremos numero de clicks con valor "1"

  Scenario: pulsar en contador de detalle
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "0"
    And pulsando boton master
    And mostrando contador en lista en posicion "0" con valor "0"
    And mostrando lista con numero de contadores "1"
    And pulsando boton contador en posicion "0"
    And iniciando pantalla detalle
    And mostrando contador con valor "1"
    And mostrando numero de clicks con valor "1"
    When pulsamos boton detalle
    Then mostraremos contador con valor "2"
    And mostraremos numero de clicks con valor "2"

  Scenario: pulsar en regresar de detalle
    Given iniciando pantalla maestro
    And mostrando lista con numero de contadores "0"
    And pulsando boton master
    And mostrando contador en lista en posicion "0" con valor "0"
    And mostrando lista con numero de contadores "1"
    And pulsando boton contador en posicion "0"
    And iniciando pantalla detalle
    And mostrando contador con valor "1"
    And mostrando numero de clicks con valor "1"
    And pulsando boton detalle
    And mostrando contador con valor "2"
    And mostrando numero de clicks con valor "2"
    When pulsamos boton regresar
    Then finalizaremos pantalla detalle
    And resumiremos pantalla maestro
    And mostraremos contador en lista en posicion "0" con valor "2"
    And mostraremos lista con numero de contadores "1"