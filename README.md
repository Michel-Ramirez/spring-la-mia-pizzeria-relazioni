# spring-la-mia-pizzeria-relazioni

## Todo
### Day 1
> [!attention] IMPORTANTE
> Ricordatevi di sganciare la vostra vecchia repository e di crearne una nuova per questo esercizio, che prosegue il lavoro della pizzeria, dove lo avevate lasciato

Nuova importante funzionalità : **le offerte speciali**!

In alcuni momenti potremmo voler vendere le nostre pizze a un prezzo scontato.

Dobbiamo quindi predisporre tutto il codice necessario per poter collegare un'offerta speciale a una pizza (in una relazione 1 a molti, cioè un’offerta speciale può essere collegata a una sola pizza, e una pizza può essere collegata a più offerte speciali).

L’offerta speciale sara' caratterizzata da:
- `data di inizio`
- `data di fine`
- `titolo`

La pagina di dettaglio della singola pizza mostrerà l'elenco delle offerte collegate e avrà un bottone “Crea nuova offerta speciale” per aggiungerne una nuova.

Accanto ad ogni offerta speciale è previsto un bottone che mi porterà a una pagina per modificarla.