@FlujoAprobacionPOU
Feature: Flujos de Aprobación POU
  Como Usuario con todos los roles
  Quiero Derivar y aprobar los planes operativos POU
  Para Validar el flujo de aprobación POU

  Background:
    Given El usuario inicia sesión
    Then Se muestra la interfaz de SISCO
    And Ingreso al modulo SISCO
    Then Se muestra la interfaz de Roles

  @CP001
  Scenario Outline: CP001 - Realizar flujo de aprobación 4 punto 1 FL0170
    Given El usuario ingresa con el "<rol>"
    Then Se muestra la interfaz de PSC Sisco
    And Selecciono el menu Planes Operativos POU
    When Selecciono el "<ambito>" y "<anio>" del Plan Operativo
    And Deriva el Plan Operativo
    Then Muestra mensaje de exito plan derivado

    Examples:
      | rol                         |  | ambito |  | anio |
      | Operador de Planeamiento UO |  | L320   |  | 2024 |
      | Supervisor UO               |  | L320   |  | 2024 |
      | Responsable UO              |  | L320   |  | 2024 |
      | Responsable de la Gerencia  |  | L320   |  | 2024 |
      | Supervisor OI Superior      |  | L320   |  | 2024 |
      | Responsable OI Superior     |  | L320   |  | 2024 |
      | Usuario de Planeamiento     |  | L320   |  | 2024 |
      | Supervisor PLPREPI          |  | L320   |  | 2024 |