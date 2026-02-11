# Fix: Laptop Restarts and Freezes at 100% (Black Screen)

## Problem Description

The laptop keeps restarting, reaches a black screen showing **100%** progress, and then **freezes** with various errors. This is typically caused by one of the following:

- Corrupted Windows Update
- Corrupted system files
- Faulty or incompatible drivers
- Disk errors (bad sectors, failing drive)
- RAM issues
- Overheating

---

## Step-by-Step Fixes (Try in Order)

### 1. Boot into Safe Mode

Safe Mode loads Windows with minimal drivers and can bypass the freeze.

1. **Force shutdown** the laptop 3 times in a row (hold power button until it turns off, then turn it back on) to trigger **Windows Recovery Environment (WinRE)**.
2. Go to: **Troubleshoot > Advanced Options > Startup Settings > Restart**
3. Press **F4** (or **4**) to boot into **Safe Mode**
4. If Safe Mode works, proceed with the fixes below from within Safe Mode.

---

### 2. Undo Recent Windows Updates

A stuck or corrupted update is the most common cause of freezing at 100%.

**From Safe Mode:**
```
Settings > Windows Update > Update History > Uninstall Updates
```
Uninstall the most recent update(s) and restart.

**From Command Prompt (WinRE > Troubleshoot > Advanced Options > Command Prompt):**
```cmd
:: List installed updates
dism /image:C:\ /get-packages | findstr "Package_for"

:: Uninstall a specific update (replace the package name)
dism /image:C:\ /remove-package /packagename:Package_for_KB5XXXXXX~...
```

---

### 3. Run System File Checker (SFC) and DISM

Repair corrupted Windows system files.

**From Safe Mode or Command Prompt:**
```cmd
:: Scan and repair system files
sfc /scannow

:: If SFC fails, run DISM first
DISM /Online /Cleanup-Image /RestoreHealth

:: Then run SFC again
sfc /scannow
```

**From WinRE Command Prompt (if Windows won't boot):**
```cmd
:: Find your Windows drive letter first
diskpart
list volume
exit

:: Run against the offline image (replace C: with your actual drive)
sfc /scannow /offbootdir=C:\ /offwindir=C:\Windows
```

---

### 4. Check and Repair Disk Errors

A failing or corrupted disk can cause freezes.

```cmd
:: Check disk for errors and fix them
chkdsk C: /f /r

:: If prompted to schedule on next restart, type Y
```

---

### 5. Reset or Roll Back Graphics/Display Drivers

Faulty display drivers are a common cause of black screen freezes.

**From Safe Mode:**
1. Open **Device Manager** (right-click Start > Device Manager)
2. Expand **Display adapters**
3. Right-click your graphics card > **Properties > Driver tab**
4. Click **Roll Back Driver** if available
5. Or click **Uninstall device** (check "Delete the driver software"), then restart to let Windows install a fresh generic driver

---

### 6. Disable Fast Startup

Fast Startup can cause boot issues and freezes.

**From Safe Mode:**
```
Control Panel > Power Options > Choose what the power buttons do
> Change settings that are currently unavailable
> Uncheck "Turn on fast startup"
> Save changes
```

**From Command Prompt:**
```cmd
powercfg /h off
```

---

### 7. Check for Overheating

Overheating causes random freezes and restarts.

- Clean dust from **air vents** and **fans**
- Use compressed air to blow out the cooling system
- Make sure the laptop is on a **hard, flat surface** (not a bed or pillow)
- Check CPU temperatures using **HWMonitor** or **Core Temp** (from Safe Mode)
- If temperatures exceed **90C under load**, consider replacing thermal paste

---

### 8. Test RAM

Faulty RAM causes random freezes and blue screen errors.

**From WinRE:**
```
Troubleshoot > Advanced Options > Command Prompt
```
```cmd
mdsched.exe
```
Choose **Restart now and check for problems**. The memory diagnostic will run before Windows loads.

**Alternative:** Download and create a bootable **MemTest86** USB drive for a more thorough test.

---

### 9. Use System Restore

Roll back to a point before the problem started.

**From WinRE:**
```
Troubleshoot > Advanced Options > System Restore
```
Select a restore point from before the issue began.

---

### 10. Reset Windows (Last Resort)

If nothing else works, reset Windows while keeping your files.

**From WinRE:**
```
Troubleshoot > Reset this PC > Keep my files
```

This reinstalls Windows but preserves your personal files. You will need to reinstall your applications.

---

## Common Error Codes and Their Fixes

| Error Code | Cause | Fix |
|---|---|---|
| `CRITICAL_PROCESS_DIED` | Corrupted system file or driver | Run SFC + DISM (Step 3) |
| `KERNEL_DATA_INPAGE_ERROR` | Disk or RAM failure | Run chkdsk (Step 4) + RAM test (Step 8) |
| `INACCESSIBLE_BOOT_DEVICE` | Corrupted boot config or driver | Run `bootrec /fixboot` and `bootrec /rebuildbcd` |
| `DRIVER_IRQL_NOT_LESS_OR_EQUAL` | Faulty driver | Roll back drivers (Step 5) |
| `PAGE_FAULT_IN_NONPAGED_AREA` | RAM or driver issue | RAM test (Step 8) + driver rollback (Step 5) |
| `WHEA_UNCORRECTABLE_ERROR` | Hardware failure (CPU/RAM/disk) | Test RAM (Step 8), check disk (Step 4), check temps (Step 7) |
| `DPC_WATCHDOG_VIOLATION` | Driver or SSD firmware issue | Update SSD firmware + rollback drivers (Step 5) |
| `SYSTEM_SERVICE_EXCEPTION` | Driver or software conflict | Boot Safe Mode, uninstall recent software |

---

## Quick Recovery Commands (from WinRE Command Prompt)

```cmd
:: Fix boot configuration
bootrec /fixmbr
bootrec /fixboot
bootrec /scanos
bootrec /rebuildbcd

:: Fix system files offline
DISM /Image:C:\ /Cleanup-Image /RestoreHealth
sfc /scannow /offbootdir=C:\ /offwindir=C:\Windows

:: Check disk
chkdsk C: /f /r
```

---

## If the Problem Persists

If none of the above fixes work, the issue is likely **hardware-related**:

1. **Failing hard drive / SSD** - Replace the storage drive
2. **Faulty RAM** - Replace the RAM module(s)
3. **Overheating CPU/GPU** - Clean cooling system and replace thermal paste
4. **Failing motherboard** - Requires professional repair

Consider taking the laptop to a qualified technician for hardware diagnostics.
