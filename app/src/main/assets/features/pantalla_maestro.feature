Feature: pantalla maestro

  Scenario: crear nuevo contador en maestro
    Given iniciamos pantalla maestro
    And mostramos lista con "longitud" contadores
    When pulsamos boton lista
    Then incluimos nuevo contador en posicion "posicion" de lista
    And mostramos contador con valor "valor"

  Scenario: pulsar en contador de maestro
    Given iniciamos pantalla maestro
    And mostramos lista con "longitud" contadores
    When pulsamos boton contador en "posicion"
    Then iniciamos pantalla detalle
    And mostramos contador con valor "valor"
    And mostramos numero de clicks con valor "valor"

  Scenario: pulsar en contador de detalle
    Given iniciamos pantalla maestro
    And mostramos lista con "longitud" contadores
    And pulsamos boton contador en "posicion"
    And iniciamos pantalla detalle
    And mostramos contador con valor "valor"
    And mostramos numero de clicks con valor "valor"
    When pulsamos boton contador
    Then mostramos contador con valor "valor"
    And mostramos numero de clicks con valor "valor"

  Scenario: pulsar en regresar de detalle
    Given iniciamos pantalla maestro
    And mostramos lista con "longitud" contadores
    And pulsamos boton contador en "posicion"
    And iniciamos pantalla detalle
    And mostramos contador con valor "valor"
    And mostramos numero de clicks con valor "valor"
    And pulsamos boton contador
    When pulsamos boton regresar
    Then finalizamos pantalla detalle
    And resumimos pantalla maestro
    And mostramos contador con valor "valor"
    And mostramos numero de clicks con valor "valor"