<?php
//Porneste sesiunea
session_start();

//Verifica daca este specificata o limba in URL
if (isset($_GET['language'])) {
    $language = $_GET['language'];

    //Dam lista de limbi valide
    $valid_languages = ['ro', 'en', 'fr', 'hu'];

    //Daca limba din URL este valida, o stocheaza in sesiune
    if (in_array($language, $valid_languages)) {
        $_SESSION['language'] = $language;
    }
}
//Daca nu exista parametru "language", verifica daca este deja setat 
elseif (isset($_SESSION['language'])) {
    $language = $_SESSION['language'];
}
//Daca nu e selectata nicio limba, steaza implicit limba romana
 else {
    $language = 'ro';
}

// Obtine numele paginii curente
$current_page = basename($_SERVER['PHP_SELF']);  

//Daca limba din URL este diferita de limba curenta, redirectioneaza la URL-ul cu limba selectata
if (isset($_GET['language']) && $_GET['language'] != $language) {
    $url = $current_page . '?language=' . $_GET['language'];
    header('Location: ' . $url);
    exit();
}
?>

<! -- Formularul pentru selectarea limbii -->
<form method="get" action="">
    <label for="language"></label>
    <select name="language" id="language" onchange="this.form.submit()">
        <option value="ro" <?php if ($language == 'ro') echo 'selected'; ?>>Română</option>
        <option value="en" <?php if ($language == 'en') echo 'selected'; ?>>English</option>
        <option value="fr" <?php if ($language == 'fr') echo 'selected'; ?>>Française</option>
        <option value="hu" <?php if ($language == 'hu') echo 'selected'; ?>>Magyar</option>
    </select>
</form>

<?php
//Schimba pagina in functie de limba selectata
if ($language == 'ro' && $current_page != 'index.php') {
    header('Location: index.php?language=ro');
    exit();
} elseif ($language == 'en' && $current_page != 'index_en.php') {
    header('Location: index_en.php?language=en');
    exit();
} elseif ($language == 'fr' && $current_page != 'index_fr.php') {
    header('Location: index_fr.php?language=fr');
    exit();
} elseif ($language == 'hu' && $current_page != 'index_hu.php') {
    header('Location: index_hu.php?language=hu');
    exit();
}
?>
