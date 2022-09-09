package com.divit.device_info_null_safety;

import java.util.HashMap;

import github.nisrulz.easydeviceinfo.base.EasyCpuMod;

public class ABIInfo {

    public HashMap<String, Object> getAbiInfo() {

        EasyCpuMod easyCpuMod = new EasyCpuMod();

        HashMap<String, Object> result = new HashMap<>();

        StringBuilder supportABI = new StringBuilder();
        for (String abis : easyCpuMod.getSupportedABIS()) {
            supportABI.append(abis).append("\n");
        }
        String supportedABI = supportABI.toString();

        result.put("supportedABI", supportedABI);

        StringBuilder support32ABI = new StringBuilder();
        for (String abis : easyCpuMod.getSupported32bitABIS()) {
            support32ABI.append(abis).append("\n");
        }
        String supported32ABI = support32ABI.toString();

        result.put("supported32ABI", supported32ABI);

        StringBuilder support64ABI = new StringBuilder();
        for (String abis : easyCpuMod.getSupported64bitABIS()) {
            support64ABI.append(abis).append("\n");
        }
        String supported64ABI = support64ABI.toString();

        result.put("supported64ABI", supported64ABI);

        return result;
    }
}
