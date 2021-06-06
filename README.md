# kambu
Zadanie rekrutacyjne

On POST request with no parameters at {/api} endpoint you will recieve data from Api and save this data to database.

On GET request with no parameters at {/currency/available} endpoint you will receive list of available currencies to convert in JSON representation following format below : <br>
[ <br>
    {<br>
        "currency": "dolar amerykański",<br>
        "code": "USD"<br>
    },<br>
    {<br>
        "currency": "dolar australijski",<br>
        "code": "AUD"<br>
    },<br>
    {<br>
        "currency": "dolar kanadyjski",<br>
        "code": "CAD"<br>
    }<br>
]<br>

On GET request with no parameters at {/currency/current-rate} endpoint you will receive list of current exchange rates for currencies in JSON representation following format below : <br>

[ <br>
    { <br>
        "currency": "dolar amerykański", <br>
        "code": "USD", <br>
        "bid": 3.6208, <br>
        "ask": 3.694 <br>
    }, <br>
    { <br>
        "currency": "dolar australijski", <br>
        "code": "AUD", <br>
        "bid": 2.8033, <br>
        "ask": 2.8599 <br>
    }, <br>
    { <br>
        "currency": "dolar kanadyjski", <br>
        "code": "CAD", <br>
        "bid": 3.0019, <br>
        "ask": 3.0625 <br>
    } <br>
] <br>

On GET request with parameters fromCurrency, toCurrency, amount at {/currency} endpoint you will receive JSON object with calculated currency.
Request body must have following structure : <br>
{ <br>
        "fromCurrency": "HUF", <br>
        "toCurrency": "PLN", <br>
        "amount": "7672.241829062452" <br>
} <br>
Recived JSON will look like the following : <br>
{ <br>
    "currency": "PLN", <br>
    "amount": 98.02056160810187 <br>
} <br>

