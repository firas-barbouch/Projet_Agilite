#Author: Firas BARBOUCH
#Author: Yanis LAGHMOURI

Feature: Les titans peuvent avoir des interactions entre eux

 Les titans peuvent s'attaquer entre eux et altérer les points de vie d'un autre 

 Scenario Outline: Un titan peut attaquer un autre titan
  Given : Un <titan1> veut se battre contre un <titan2>
  When : Un <titan1> attaque un autre <titan2>
  Then : Le <titan1> attaqué perd des <PV> equivalent à la <DPS> du <titan2> attaquant
  
  Examples: 
      | titan1 | PV  | titan2  | DPS | PvTitan1
      | titanA | 100 | titanB  | 20  | 80
      | titanB | 100 | titanC  | 30  | 70
  
  
  
 Scenario: Un titan peut être transférer d'un humain à un autre
  Given : Lorsqu'un humain souhaite transférer son titan à un autre humain
  When : Un humain mange un humain qui possède un titan
  Then : Le titan de l'humain qui a été mangé est transféré à l'humain qui l'a mangé
  
  