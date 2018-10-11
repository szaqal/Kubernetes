# NETWORK POLICIES

## Listing applied policies

```
kubectl get netpol --all-namespaces
```

## Dissallow outgoing traffic 

```
# kubectl exec -it busybox sh
```

```
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: deny-egress
spec:
  podSelector:
    matchLabels:
      app: busybox
  policyTypes:
  - Egress
  egress: []
```

### Dissallow with exception to SSH

Disables all outgoing traffic except TCP port 22

```
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: deny-egress
spec:
  podSelector:
    matchLabels:
      app: busybox                                                                                                                                                                                                                            
  policyTypes:
  - Egress
  egress:
  - ports:
    - port: 22
      protocol: TCP
```

## Dissallow incoming traffic pod2pod

Dissallow all trafic to pod ```app: memcached```

```
kind: NetworkPolicy
apiVersion: networking.k8s.io/v1
metadata:
  name: memcached-deny
spec:
  podSelector:
    matchLabels:
      app: memcached
  ingress: []
```

### Allow from particular pod

Allow ```busybox``` to connect pod ```app: memcached```

```
kind: NetworkPolicy
apiVersion: networking.k8s.io/v1
metadata:
  name: memcached-allow-busybox
spec:
  podSelector:
    matchLabels:
      app: memcached
  ingress:
  - from:
      - podSelector:
          matchLabels:
            app: busybox
```

## Disable all traffic to namespace

```
kind: NetworkPolicy
apiVersion: networking.k8s.io/v1
metadata:
  name: default-deny-all
  namespace: default
spec:
  podSelector: {}
  ingress: []

```

### Disable request from other namespaces


```
kind: NetworkPolicy
apiVersion: networking.k8s.io/v1
metadata:
  namespace: testing
  name: other-namespace
spec:
  podSelector:
    matchLabels:
  ingress:
  - from:
    - podSelector: {}

```
