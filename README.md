# Read Me First
This is the frontend-service for the Stakater Technical Task.

Since this is dependent on the backend-api service. Please make sure that the backend-api service pod is deployed first 
before executing this.

This contains the FRONTEND_BACKEND_API_REST_URL environment variable which is needed to be modified first before deploying. 
Since the IP Address of the backend-api pod is needed in order for the front-end service to call
the backend-api

Note: For the Repository of backend-api please see: https://github.com/navyzil/backend-api

# Getting Started
## Part I. Installing and deploying the frontend-service
1. Execute mvn clean install to create the jar file

2. Execute the following to build the jar file as a docker image: docker build -t backend-api <path_to_project>/frontend-service

        example: docker build -t backend-api C:/Users/User/Documents/Projects/StakaterTechnicalTask/frontend-service

3. Check first the backend-api pod's IP address via executing: kubectl get pods -o wide. 
   Use the IP Address of the backend-api to FRONTEND_BACKEND_API_REST_URL in frontend-service-config.yaml
   

4. Apply the changes in frontend-service-config.yaml: kube apply -f <path_to_project>/k8/frontend-service-config.yaml

        example:kubectl apply -f C:/Users/User/Documents/Projects/StakaterTechnicalTask/backend-api/k8/frontend-service-config.yaml


## Part II. Running The frontend-service service in Kubernettes
1. execute frontend-service pod: kube apply -f <path_to_project>/k8/frontend-service-pod.yaml

        example:kubectl apply -f C:/Users/User/Documents/Projects/StakaterTechnicalTask/frontend-service/k8/frontend-service-pod.yaml
This will execute auto run on the cluster.

2. Check if the frontend-service pod is running by executing: kubectl get pods -o wide

        C:> kubectl get pods -o wide

This will yield the following result:

    NAME               READY   STATUS    RESTARTS   AGE   IP          NODE             NOMINATED NODE   READINESS GATES
    backend-api        1/1     Running   0          2m   10.1.0.26   docker-desktop   <none>           <none>
    frontend-service   1/1     Running   0          1m   10.1.0.27   docker-desktop   <none>           <none>

Once you see the STATUS is Running then we can view the frontend-service    

3. To view the backend-api on the local browser, execute the following command: kubectl port-forward pod/frontend-service port:port
   The port is defined based on the containerPort located in the backend-api-pod.yaml The usual practice is the ports in frontend-service-config.yaml and backend-api-pod.yaml are same values.

        example: kubectl port-forward pod/frontend-service 8886:8886
From here, once you execute localhost:<port_number>/frontend-service on your browser. You will expect to see the word "<Date Time> Hello <BACKEND_NAME>"

    example: If we type localhost:8886/frontend-service in the browser it will return 27/06/2021 06:32:39 Hello Denzil

## Part III. Restarting the pod if frontend-service-config.yaml is modified
1. Once the changes is done in the frontend-service-config.yaml, we need to perform a force delete of the frontend-service pod:

        kubectl delete pods frontend-service --force
This will stop and remove the outdated pod.

2. Follow the steps in Part II.
    
