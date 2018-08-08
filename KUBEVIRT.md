# Kubevirt

## Check virtualization capabilities

```
# virt-host-validate qemu
  QEMU: Checking for hardware virtualization                                 : WARN (Only emulated CPUs are available, performance will be significantly limited)
  QEMU: Checking if device /dev/vhost-net exists                             : PASS
  QEMU: Checking if device /dev/net/tun exists                               : PASS
  QEMU: Checking for cgroup 'memory' controller support                      : PASS
  QEMU: Checking for cgroup 'memory' controller mount-point                  : PASS
  QEMU: Checking for cgroup 'cpu' controller support                         : PASS
  QEMU: Checking for cgroup 'cpu' controller mount-point                     : PASS
  QEMU: Checking for cgroup 'cpuacct' controller support                     : PASS
  QEMU: Checking for cgroup 'cpuacct' controller mount-point                 : PASS
  QEMU: Checking for cgroup 'devices' controller support                     : PASS
  QEMU: Checking for cgroup 'devices' controller mount-point                 : PASS
  QEMU: Checking for cgroup 'net_cls' controller support                     : PASS
  QEMU: Checking for cgroup 'net_cls' controller mount-point                 : PASS
  QEMU: Checking for cgroup 'blkio' controller support                       : PASS
  QEMU: Checking for cgroup 'blkio' controller mount-point                   : PASS
  QEMU: Checking for device assignment IOMMU support                         : WARN (Unknown if this platform has IOMMU support)

```

## Turn on emulation

```
apiVersion: v1
kind: ConfigMap
metadata:
  name: kubevirt-config
  namespace: kube-system
data:
  debug.useEmulation: "true"
```

## Pull and release

```
wget https://github.com/kubevirt/kubevirt/releases/download/v0.7.0/kubevirt.yaml
```

```
create -f kubevirt.yaml --validate=false
```

At the time of writing there were validation errors on kubernets v11.1 version hence these were ignored


### Verify

```
# kubectl get pods -n kube-system | grep "virt"
virt-api-5d5bf7c74c-2ddrp                   1/1       Running   0          49s
virt-api-5d5bf7c74c-dkw9x                   1/1       Running   0          49s
virt-controller-6fc9c79476-lj6zx            1/1       Running   0          49s
virt-controller-6fc9c79476-phwg6            1/1       Running   0          49s
virt-handler-kb4nj                          1/1       Running   0          49s
virt-handler-z9p6f                          1/1       Running   0          49s
virt-handler-zlfbz                          1/1       Running   0          49s
```

### Verify capabilities

To capabilities needs to be available for Kubernetes verify with ``` kubectl get nodes -o yaml```

```
allocatable:
  devices.kubevirt.io/kvm: "110"
  devices.kubevirt.io/tun: "110"

```


## Nested virtualiation

This may be required whenever kubernets workers are running on VMs instead of bare-metal

```
$ cat /sys/module/kvm_intel/parameters/nested
Y

```
Edit VM

```
virsh # edit nested_virt

```
Change CPU line to this

```
  <cpu mode='host-passthrough'/>

```

Restart VM and verify is all KVM is available

```
Model name:            Intel(R) Xeon(R) CPU           L5520  @ 2.27GHz
Stepping:              5
CPU MHz:               2260.990
BogoMIPS:              4521.98
Virtualization:        VT-x
Hypervisor vendor:     KVM
Virtualization type:   full

```

## References

[Kubevirt API](https://kubevirt.io/api-reference/v0.7.0/index.html)
