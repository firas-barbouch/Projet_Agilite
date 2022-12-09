#Author: Firas BARBOUCH
#Author: Yanis LAGHMOURI

Feature: US_000 Lier des humains et des titans
	Chaque titan doit être lier à un et un seul humain et inversement un humain peut être lier à plusieurs titans.
	
	Scenario: Lier un titan à humain et vérifier inversement
	Given un Humain est propriétaire d'un ou plusieurs titan
	When un humain veut se lier à un titan
	Then le titan est automatiquement lié à l'humain
	
	Scenario: Un titan est unique à chaque humain
	Given un Humain ne peut pas posséder deux fois le même titan
	When un humain veut se lier une deuxième fois avec un titan
	Then le titan et l'humain ne seront pas liés une deuxième fois