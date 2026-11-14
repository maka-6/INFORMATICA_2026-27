/*
 * Autore: Youness Makaoui
 * Data: 12/11/2026
 * Classe: 5G
 * Descrizione: Gestione di un form di registrazione
*/
<?php

	$file = "usersDB.csv";
	$archive = [];
	$db = fopen($file,"w") or die("Error");
?>