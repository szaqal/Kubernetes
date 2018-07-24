# Kubernetes Notes

## Tooling 

[HELM](HELM.md)

#### Show dashboard token

```
kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')
```

#### Froce pod removal

```
kubectl delete pod foo --grace-period=0 --force
```
