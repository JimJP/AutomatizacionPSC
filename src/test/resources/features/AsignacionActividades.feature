@AsignacionActividades @Validaciones
Feature: Menú: Asignación de Servicios y Actividades
  Para Acceder a Sisco
  Como Usuario de Planeamiento
  Quiero Validar la funcionalidad Asignación de Servicios y Actividades

  Background:
    Given El usuario inicia sesión
    Then Se muestra la interfaz de SISCO
    And Ingreso al modulo SISCO
    Then Se muestra la interfaz de Roles
    And Selecciono el rol Usuario de Planeamiento
    Then Se muestra la interfaz de PSC

  @CP001
  Scenario Outline: CP001 - Asignar las modalidades y actividades a una UO
    Given El usuario de planeamiento ingresa a Asignacion de Servicios
    And Hago clic en la opción "Editar" del periodo 2024
    Then Se muestra el listado de asignaciones de UO y OCI
    And Hago clic en "Acciones" y luego en "Agregar Asignación"
    Then Se muestra la interfaz "Agregar Asignación de Actividades"
    And Busco y agrego la UO de forma manual "<codigoUO>"
    And Hago clic en el botón "Buscar"
    When Selecciono un catálogo PNC y un grupo de actividades
    And Hago clic en el botón "Buscar" del modal
    And Agrego todos los servicios y actividades
    Then Se muestran todas las actividades agregadas a la UO
    And Agrego la Unidad de Medida y Producto a las actividades
    And Hago clic en el botón "Guardar"
    Then Se muestra un mensaje de éxito
    Examples:
      | codigoUO |
      | D300     |