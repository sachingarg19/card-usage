# card-usage
Technology stack

SpringBoot 1.4.2.RELEASE, Spring REST Jersey API service using GET method, RestTemplate, Maven. PostMan will be used on demonstration of consuming REST service. Alternatively results can be seen by hitting below given URLs from browser. 
Additionally, this project contains no XML. Spring config is fully annotation driven.

System requirement to install

1. Maven needs to installed either to use through commandline or using eclipse.
2. JDK 1.8 3
3. PostMan or a browser should be installed. If not installed use below link. Alternative to postman is to hit URLs through browser.
Postman installation link
https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en


Installation Steps

1. Goto Terminal. 
2. Do git clone https://github.com/prashantksingh10/card-usage.git
3. Do cd "card-usage"
4. Execute "mvn clean install spring-boot:run" 
5. Launch Postman or browser and hit below URLs 
6. Use http://localhost:8080/usageAnalytic to see the results. This URl is to display result for the first problem. Where Users monthly transactions are displayed in the required format.
7. Use http://localhost:8080/usageAnalytic-ignoreDonuts to see the results. This URl is to display result where transactions for specific merchant is ignored. 






