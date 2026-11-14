<?php
/*
 * Autore: Youness Makaoui
 * Data: 08/11/2026
 * Classe: 5G
 * Descrizione:
 */

$testoInput = "   Benvenuti nel FANTASTICO mondo della programmazione PHP! ;)   ";
$testo = trim($testoInput);

if (stripos($testo, "PHP") !== false) {
    $presente = "Sì";
} else {
    $presente = "No";
}
?>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Analizzatore di testo</title>
</head>
<body>
    <h1>Analizzatore di testo</h1>

    <table border="1">
        <tr>
            <th>Parametro</th>
            <th>Funzione Utilizzata</th>
            <th>Risultato</th>
        </tr>
        <tr>
            <td>Lunghezza testo originale</td>
            <td>strlen</td>
            <td><?php echo strlen($testoInput); ?></td>
        </tr>
        <tr>
            <td>Lunghezza testo pulito</td>
            <td>trim + strlen</td>
            <td><?php echo strlen($testo); ?></td>
        </tr>
        <tr>
            <td>Minuscolo</td>
            <td>strtolower</td>
            <td><?php echo strtolower($testo); ?></td>
        </tr>
        <tr>
            <td>Maiuscolo</td>
            <td>strtoupper</td>
            <td><?php echo strtoupper($testo); ?></td>
        </tr>
        <tr>
            <td>Prima lettera maiuscola</td>
            <td>ucwords</td>
            <td><?php echo ucwords(strtolower($testo)); ?></td>
        </tr>
        <tr>
            <td>Numero di parole</td>
            <td>str_word_count</td>
            <td><?php echo str_word_count($testo); ?></td>
        </tr>
        <tr>
            <td>Presenza di PHP</td>
            <td>stripos</td>
            <td><?php echo $presente; ?></td>
        </tr>
        <tr>
            <td>Sostituzione FANTASTICO</td>
            <td>str_ireplace</td>
            <td><?php echo str_ireplace("FANTASTICO", "MERAVIGLIOSO", $testo); ?></td>
        </tr>
        <tr>
            <td>Primi 20 caratteri</td>
            <td>substr</td>
            <td><?php echo substr($testo, 0, 20); ?></td>
        </tr>
        <tr>
            <td>Slug</td>
            <td>strtolower + str_replace</td>
            <td><?php echo str_replace(" ", "-", strtolower($testo)); ?></td>
        </tr>
    </table>
</body>
</html>
