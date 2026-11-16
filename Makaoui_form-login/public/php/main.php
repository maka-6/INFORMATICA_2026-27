<?php
/*
 * Autore: Youness Makaoui
 * Data: 12/11/2026
 * Classe: 5G
 * Descrizione: Gestione di un form di registrazione e di login
 */

$file = "usersDB.csv";   // ogni riga del file: username;password

// Prendo i dati inviati dal form
$azione   = $_POST["azione"];
$username = $_POST["username"];
$password = $_POST["password"];

// Cerco l'username nel file
$trovato = false;
$passwordSalvata = "";

if (file_exists($file)) {
    $righe = file($file);              // legge il file e mette ogni riga in un array
    foreach ($righe as $riga) {
        $campi = explode(";", $riga);  // divide la riga in username e password
        if ($campi[0] == $username) {
            $trovato = true;
            $passwordSalvata = trim($campi[1]);
        }
    }
}

// ---------- REGISTRAZIONE ----------
if ($azione == "registrazione") {

    if ($password != $_POST["conferma"]) {
        $messaggio = "Le due password non coincidono.";
    } else {
        if ($trovato) {
            $messaggio = "Username già in uso.";
        } else {
            // cifro la password così nel file non si legge in chiaro
            $passwordCifrata = password_hash($password, PASSWORD_DEFAULT);
            // FILE_APPEND = aggiunge in fondo al file senza cancellare il resto
            file_put_contents($file, $username . ";" . $passwordCifrata . "\n", FILE_APPEND);
            $messaggio = "Registrazione completata! Ora puoi accedere.";
        }
    }
}

// ---------- LOGIN ----------
if ($azione == "login") {

    // password_verify controlla se la password scritta corrisponde a quella cifrata
    if ($trovato && password_verify($password, $passwordSalvata)) {
        $messaggio = "Benvenuto, " . $username . "!";
    } else {
        $messaggio = "Username o password errati.";
    }
}


?>
<!DOCTYPE html>
    <html>
        <head>
            <link rel="stylesheet" href="../css/style.css">
            <title>Risultato</title>
        </head>
        <body>
        <h1><?php echo $messaggio; ?></h1>
        <p><a href="../index.html">Torna alla home</a></p>
    </body>
</html>