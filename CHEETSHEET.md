# Cheetsheet

* Get all objects 

```
kubectl get all --all-namespaces
```

* Dashboard token

```
kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')
```

* Force pod removal

```
kubectl delete pod foo --grace-period=0 --force
```

* Defining output 

```
kubectl get nodes -o wide
kubectl get pods -o wide --all-namespaces

```
