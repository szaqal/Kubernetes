# HELM

## Terminology

* ***Chart*** something like apt, dpkg or RPM

* ***Repository*** location from which packages can be installed like CPAN or Fedora Package Database

* ***Release*** instance of Chart

* ***Helm*** Client

* ***Tiller*** Server - runs on kubernetes

## Install

### Create service account

```
root@ion-kubernetes-01:/home/malczyk# kubectl create -f tiller_sa.yml 
serviceaccount/tiller created
clusterrolebinding.rbac.authorization.k8s.io/tiller created

```

### Install helm

```
root@ion-kubernetes-01:/home/malczyk# snap install helm
helm 2.9.1 from 'snapcrafters' installed

```
It may not be on the path

```
export PATH=/snap/bin:$PATH
kubectl create clusterrolebinding add-on-cluster-admin --clusterrole=cluster-admin --serviceaccount=kube-system:default
root@ion-kubernetes-01:~/.kube# cp config /root/snap/helm/common/kube/config
root@ion-kubernetes-01:~/.kube# helm init --service-account tiller


```
Verify if it's running

```
root@ion-kubernetes-01:~/.kube# kubectl get deployments --all-namespaces
NAMESPACE     NAME                   DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
kube-system   calico-typha           0         0         0            0           15d
kube-system   coredns                2         2         2            2           15d
kube-system   kubernetes-dashboard   1         1         1            1           15d
kube-system   tiller-deploy          1         1         1            1           2m
```

Create account 


## Usage

### Looking for charts

```
root@ion-kubernetes-01:~/.kube# helm search memcached
NAME            	CHART VERSION	APP VERSION	DESCRIPTION                                       
stable/memcached	2.2.0        	1.5.6      	Free & open source, high-performance, distribut...
stable/mcrouter 	0.1.1        	0.36.0     	Mcrouter is a memcached protocol router for sca...
```

### Install chart

```
helm install --name test-memcached stable/memcached
```

```
root@ion-kubernetes-01:/home/malczyk# helm list
NAME          	REVISION	UPDATED                 	STATUS  	CHART          	NAMESPACE
test-memcached	1       	Wed Jul 25 15:28:52 2018	DEPLOYED	memcached-2.2.0	default  
```

### Others

* ```helm inspect```

## Development

* Create new chart ```helm create test-chart```

* Packaging ```helm package test-chart```


### Repositories

#### S3

```
helm plugin install https://github.com/hypnoglow/helm-s3.git
```

* [Google Repo](https://kubernetes-charts.storage.googleapis.com/)
