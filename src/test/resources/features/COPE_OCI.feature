@COPE @Validaciones
Feature: Capacidad Operativa validaciones y reglas de negocio
  Para acceder a Sisco
  Como Operador de Planeamiento OCI
  Quiero validar la funcionalidad Capacidad Operativa

  Background:
    Given El usuario inicia sesión
    Then Se muestra la interfaz de SISCO
    And Ingreso al modulo SISCO
    Then Se muestra la interfaz de Roles
    And Selecciono el Rol Operador de Planeamiento Oci
    Then Se muestra la interfaz de PSC

  @COPE @CP001
  Scenario Outline: CP001 - Validar que un Personal de OCI y a la vez perteneciente a UO no pueda ser registrado a la Capacidad Operativa del OCI, debe mostrar un mensaje indicando que debe ser agregado y compartido desde la UO
    Given El usuario de OCI ingresa a Capacidad Operativa
    When Selecciono el ambito
    And Doy clic en Agregar Personal
    And Doy clic en Buscar y agregar "<nroDocumento>"
    And Selecciono el Personal buscado y lo agrego
    And Doy clic al botón Guardar Capacidad Operativa
    Then Se muestra el mensaje de validacion y se impide la grabación
    Examples:
      | nroDocumento |
      | 40472538     |

    @COPE @CP002
    Scenario Outline: CP002 - Validar que al intentar buscar un Personal por su DNI incorrecto (alfanúmerico) muestre un mensaje de excepción indicando que el DNI no tiene el formato correcto.
      Given El usuario de OCI ingresa a Capacidad Operativa
      When Selecciono el ambito
      And Doy clic en Agregar Personal
      And Doy clic en Buscar y agregar "<nroDocumento>"
      Then Se muestra el mensaje Ingrese número DNI valido
      Examples:
        | nroDocumento |
        | T3xt0        |