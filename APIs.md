1. Create new Team

curl --location --request POST 'localhost:8080/capm/createNewTeam' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Sub"
}'

2. Create new employee as manager

curl --location --request POST 'localhost:8080/capm/createNewEmployee' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Ramesh",
    "code": "E01",
    "teamId":"2",
    "accessLevel": "MANAGER"
}'

Create new employee

curl --location --request POST 'localhost:8080/capm/createNewEmployee' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Suresh",
    "code": "E02",
    "teamId":"2",
    "accessLevel": "MANAGER"
}'