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
