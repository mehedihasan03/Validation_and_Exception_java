# CURL commands for testing api

	
## User Save
	
	curl --location --request GET 'http://localhost:8585/api/v1/user/3' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"name":"mehedi",
		"email":"mehedi@gmail.com",
		"mobile":"01621640037",
		"gender":"male",
		"age":29,
		"nationality":"Bangladeshi"
	}'
	
## User check by userId

	curl --location --request GET 'http://localhost:8585/api/v1/user/1' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"name":"mehedi",
		"email":"mehedi@gmail.com",
		"mobile":"01621640037",
		"gender":"male",
		"age":29,
		"nationality":"Bangladeshi"
	}'


## User validation

	curl --location --request POST 'http://localhost:8585/api/v1/user' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"name":null,
		"email":"mehedigmail.com",
		"mobile":"0161640037",
		"gender":"male",
		"age":19,
		"nationality":""
	}'

## Output

	{
		"nationality": "must not be blank",
		"name": "Name shouldn't be null",
		"mobile": "mobile number should be valid",
		"age": "must be greater than or equal to 20",
		"email": "Email should be valid"
	}


## Exception Handle

	curl --location --request GET 'http://localhost:8585/api/v1/user/3' \
	--header 'Content-Type: application/json' \
	--data-raw '{
		"name":null,
		"email":"mehedigmail.com",
		"mobile":"0161640037",
		"gender":"male",
		"age":19,
		"nationality":""
	}'

## Output

	{
		"errorMessage": "User not found with this UserId : 3"
	}
