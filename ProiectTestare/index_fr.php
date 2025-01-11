<! -- Include fisierul header care contine formularul de selectare a limbii -->
<?php include('header.php'); ?>

<html>
<head>
    <! -- Include fisierul CSS pentru stilizare -->
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<! -- Formular pentru conversie -->
    <form method="post" action="">
        <! -- Selectarea valutei din care se face conversia -->
        <label for="currency_a">Convertir de:</label>
        <select name="currency_a" id="currency_a">
            <option value="RON">RON</option>
            <option value="EUR">EUR</option>
            <option value="USD">USD</option>
            <option value="CAD">CAD</option>
            <option value="GBP">GBP</option>
            <option value="HUF">HUF</option>
        </select>
        <br>

        <! -- Selectarea valutei in care se face conversia -->
        <label for="currency_b">En:</label>
        <select name="currency_b" id="currency_b">
            <option value="RON">RON</option>
            <option value="EUR">EUR</option>
            <option value="USD">USD</option>
            <option value="CAD">CAD</option>
            <option value="GBP">GBP</option>
            <option value="HUF">HUF</option>
        </select>
        <br>

        <! -- Introducerea sumei ce trebuie schimbata -->
        <label for="amount">Montant</label>
        <input type="text" id="amount" name="amount">
        <br>

        <! -- Butonul pentru trimiterea formularului -->
        <input type="submit" value="Envoyer" id="send">
    </form>

    <! -- Afisarea rezultatului conversiei -->
    <div class="result-box">
    <?php 
        //Initializeaza variabila in care se va salva mesajul de eroare
        $error = "";
        // Verifica daca formularul a fost trimis
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            //Scoate datele din formular 
            $currency_a = isset($_POST['currency_a']) ? $_POST['currency_a'] : '';
            $currency_b = isset($_POST['currency_b']) ? $_POST['currency_b'] : '';
            $amount = isset($_POST['amount']) ? $_POST['amount'] : '';

            //Inlocuieste virgula cu punct pentru a putea prelucra datele
            $amount = str_replace(',', '.', $amount);

            //Verifica daca suma introdusa este un numar
            if (!is_numeric($amount)) {
                $error = "Vous devez entrer un nombre."; //Adauga mesaj de eroare daca suma nu este numar
            }
            else
            {
                //Afiseaza optiunile alese
                echo "Vous avez choisi de convertir de $currency_a en $currency_b<br>";
                $formatted_amount = str_replace('.', ',', $amount);
                echo "Le montant que vous souhaitez convertir est: $formatted_amount $currency_a<br>";

                //Cazul in care valuta este acceeasi
                if ($currency_a == $currency_b) {
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b";
                }

                //Conversii pentru RON
            
                if ($currency_a == 'RON' && $currency_b == 'EUR') {
                    $converted_amount = $amount * 0.20;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                } elseif ($currency_a == 'EUR' && $currency_b == 'RON') {
                    $converted_amount = $amount * 4.98;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b RON";
                }

                if ($currency_a == 'RON' && $currency_b == 'USD') {
                    $converted_amount = $amount * 0.21;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b USD";
                } elseif ($currency_a == 'USD' && $currency_b == 'RON') {
                    $converted_amount = $amount * 4.71;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b RON";
                }

                if ($currency_a == 'RON' && $currency_b == 'CAD') {
                    $converted_amount = $amount * 0.30;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b CAD";
                } elseif ($currency_a == 'CAD' && $currency_b == 'RON') {
                    $converted_amount = $amount * 3.36;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b RON";
                }

                if ($currency_a == 'RON' && $currency_b == 'GBP') {
                    $converted_amount = $amount * 0.17;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b GBP";
                } elseif ($currency_a == 'GBP' && $currency_b == 'RON') {
                    $converted_amount = $amount * 5.95;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b RON";
                }

                if ($currency_a == 'RON' && $currency_b == 'HUF') {
                    $converted_amount = $amount * 81.75;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b HUF";
                } elseif ($currency_a == 'HUF' && $currency_b == 'RON') {
                    $converted_amount = $amount * 0.012;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b RON";
                }

                //Conversii pentru EUR
            
                if ($currency_a == 'EUR' && $currency_b == 'USD') {
                    $converted_amount = $amount * 1.06;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b USD";
                } elseif ($currency_a == 'USD' && $currency_b == 'EUR') {
                    $converted_amount = $amount * 0.95;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                if ($currency_a == 'EUR' && $currency_b == 'CAD') {
                    $converted_amount = $amount * 1.48;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b CAD";
                } elseif ($currency_a == 'CAD' && $currency_b == 'EUR') {
                    $converted_amount = $amount * 0.68;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                if ($currency_a == 'EUR' && $currency_b == 'GBP') {
                    $converted_amount = $amount * 0.84;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b GBP";
                } elseif ($currency_a == 'GBP' && $currency_b == 'EUR') {
                    $converted_amount = $amount * 1.20;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                if ($currency_a == 'EUR' && $currency_b == 'HUF') {
                    $converted_amount = $amount * 406.88;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b HUF";
                } elseif ($currency_a == 'HUF' && $currency_b == 'EUR') {
                    $converted_amount = $amount * 0.0024;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                //Conversii pentru USD
            
                if ($currency_a == 'USD' && $currency_b == 'CAD') {
                    $converted_amount = $amount * 1.40;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b CAD";
                } elseif ($currency_a == 'CAD' && $currency_b == 'USD') {
                    $converted_amount = $amount * 0.71;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                if ($currency_a == 'USD' && $currency_b == 'GBP') {
                    $converted_amount = $amount * 0.79;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b GBP";
                } elseif ($currency_a == 'GBP' && $currency_b == 'USD') {
                    $converted_amount = $amount * 1.26;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                if ($currency_a == 'USD' && $currency_b == 'HUF') {
                    $converted_amount = $amount * 385.14;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b HUF";
                } elseif ($currency_a == 'HUF' && $currency_b == 'USD') {
                    $converted_amount = $amount * 0.0026;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                //Conversii pentru CAD
            
                if ($currency_a == 'CAD' && $currency_b == 'GBP') {
                    $converted_amount = $amount * 0.56;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b GBP";
                } elseif ($currency_a == 'GBP' && $currency_b == 'CAD') {
                    $converted_amount = $amount * 1.77;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                if ($currency_a == 'CAD' && $currency_b == 'HUF') {
                    $converted_amount = $amount * 274.69;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b HUF";
                } elseif ($currency_a == 'HUF' && $currency_b == 'CAD') {
                    $converted_amount = $amount * 0.0036;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }

                //Conversii pentru GBP
        
                if ($currency_a == 'GBP' && $currency_b == 'HUF') {
                    $converted_amount = $amount * 486.67;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b HUF";
                } elseif ($currency_a == 'HUF' && $currency_b == 'GBP') {
                    $converted_amount = $amount * 0.0020;  // Curs BNR din 19.11.2024
                    $converted_amount = str_replace('.', ',', $converted_amount);
                    echo "Selon le taux de change de la BNR du 19.11.2024, le montant converti en $currency_b est: $formatted_amount $currency_b EUR";
                }
            }
            //Afisare eroare daca exista
            if (!empty($error)) {
                echo "<p style='color: red;'>$error</p>";
            }
        }        
        ?>
    </div>
    </div>
</body>
</html>