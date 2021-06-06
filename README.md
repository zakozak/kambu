# kambu
Zadanie rekrutacyjne

On POST request with no parameters at {/api} endpoint you will recieve data from Api and save this data to database.

On GET request with no parameters at {/currency/available} endpoint you will receive list of available currencies to convert in JSON representation following format below :
[
    {
        "currency": "dolar amerykański",
        "code": "USD"
    },
    {
        "currency": "dolar australijski",
        "code": "AUD"
    },
    {
        "currency": "dolar kanadyjski",
        "code": "CAD"
    }
]

On GET request with no parameters at {/currency/current-rate} endpoint you will receive list of current exchange rates for currencies in JSON representation following format below :

[
    {
        "currency": "dolar amerykański",
        "code": "USD",
        "bid": 3.6208,
        "ask": 3.694
    },
    {
        "currency": "dolar australijski",
        "code": "AUD",
        "bid": 2.8033,
        "ask": 2.8599
    },
    {
        "currency": "dolar kanadyjski",
        "code": "CAD",
        "bid": 3.0019,
        "ask": 3.0625
    }
]

On GET request with parameters fromCurrency, toCurrency, amount at {/currency} endpoint you will receive JSON object with calculated currency.
Request body must have following structure :
{
        "fromCurrency": "HUF",
        "toCurrency": "PLN",
        "amount": "7672.241829062452"
}
Recived JSON will look like the following :
{
    "currency": "PLN",
    "amount": 98.02056160810187
}

