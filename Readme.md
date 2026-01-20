bcrypt password encoder
  - from the spring securtiy package
  - to use it we can directly use the password encoder
  -  we inject anywhere we need
  -  but before that create the bean of that so spring mangages the lifecycle
  - whenever we ask bcrypepasswordencoder will get it for configuarations
  - encode method of bcrypt

to make the authentication availaible
 - there is anotation @EnableWebSecurity
 - now we nedd to http confiug
 -  disbale csrf
     - becasue we are using stateless
     - might be kepts on by default if using session
 
// now use the security filterchain 
    its a bean which object is managed by the spring container
here we build the http httpsecurity htpp
securityfilterchain
now by defailt all request to any api is forbidden
msg err both forbidden
status 403

// to get riid of this we used requestmatth add request and permit them
// also then disable the csrf and it requires the callback
request.requestMatchers("/api/v1/auth/signup/*").permitAll();

ok so next
also added the sigin in the requestpatcher to permit without login
