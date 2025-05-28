# SYNFAD: An Adaptive Multi-Layer Fusion Framework for Complex SYN Flood Mitigation in Software-Defined IoT Networks

This repository contains the source code, configuration files, and documentation for SYNFAD, a novel SDN-enabled framework designed to provide adaptive protection against complex SYN flooding attacks in IoT networks. SYNFAD integrates multiple layers of detection and mitigation, leveraging P4-enabled switches and intelligent control plane algorithms.

## Project Overview

SYNFAD combines several key modules to provide robust protection:

* **P4-ESTP Module:** Implements data plane-based early stage threat prevention using P4, providing real-time traffic monitoring and feature extraction.
* **AMCE Module:** Utilizes an Adaptive Meta-based Confidence Ensembling algorithm for accurate attack classification in the control plane.
* **MLDM Module:** Implements a Multi-Layer Distributed Mitigation strategy to effectively counter advanced SYN flood attacks through coordinated control plane actions.
* **LDMC Architecture:** Provides a distributed control plane for coordinated actions across multiple controllers.

This repository provides a fully integrated implementation of SYNFAD, along with individual modules for flexible exploration and deployment.

## Repository Structure

The repository is organized as follows:

* **`AMCE - java (ONOS, ODL, Flood, Beacon)/`:** Contains Java source files for the AMCE module, compatible with ONOS, ODL, Floodlight, and Beacon controllers.
* **`AMCE - Python (Ryu & POX)/`:** Contains Python source files for the AMCE module, compatible with Ryu and POX controllers.
* **`LDMC - Beacon - java/`**, **`LDMC - Floodlight - java/`**, **`LDMC - ONOS - java/`**, **`LDMC - Opendaylight - java/`:** Contains Java source files for the LDMC module, tailored for specific controllers.
* **`LDMC - POX - Python/`**, **`LDMC - Ryu - Python/`:** Contains Python source files for the LDMC module, tailored for specific controllers.
* **`MLDM - java (ONOS, ODL, Flood, Beacon)/`:** Contains Java source files for the MLDM module, compatible with ONOS, ODL, Floodlight, and Beacon controllers.
* **`MLDM - Python (Ryu & POX)/`:** Contains Python source files for the MLDM module, compatible with Ryu and POX controllers.
* **`P4_tutorial/`:** Contains tutorial materials and examples related to P4 programming.
* **`P4-Mininet_App.py`:** Python script for setting up the SD-IoT network using Mininet.
* **`P4runtime_switch.py`:** Python script for interacting with the P4 switch using P4Runtime.
* **`P4-SW[1-4]-runtime/`:** Contains JSON configuration files for the P4 switches.
* **`P4-ESTP Module App.p4`:** The P4 application for the P4-ESTP module, implementing early stage threat prevention in the data plane.
* **`SYNFAD-Topology.py`:** Python script for setting up the SYNFAD network topology.
* **`SYNFAD-Top-JSON.json`:** JSON file defining the network topology for SYNFAD.
* **`P4-ESTP Module - P4.pdf`**, **`AMCE - java (ONOS, ODL, Flood, Beacon).pdf`**, etc.: PDF files containing source code, explanations, and deployment instructions for each module.

## Getting Started

To run the SYNFAD framework, follow these general steps:

1.  **Environment Setup:** Ensure you have the necessary software installed:
    * Mininet
    * P4 compiler (`p4c`)
    * P4 runtime environment (e.g., `simple_switch`)
    * ONOS, ODL, Floodlight, Beacon, Ryu, or POX controllers
    * Python 3 with required libraries (see respective module files for dependencies).
    * Java Development Kit (JDK) for Java-based modules.

2.  **Network Setup:** Use `SYNFAD-Topology.py` and `P4-Mininet_App.py` to create the SD-IoT network topology in Mininet.

3.  **P4 Switch Configuration:** Compile the P4 program (`P4-ESTP Module App.p4`) and configure the P4 switches using the provided JSON configuration files (`P4-SW[1-4]-runtime/`).

4.  **AMCE Training:** Train the AMCE module using the provided training data and instructions in the respective module's PDF file.

5.  **Controller Deployment:** Deploy the AMCE, LDMC, and MLDM modules on your chosen SDN controller (ONOS, ODL, Floodlight, Beacon, Ryu, or POX) using the instructions in the respective PDF files.

6.  **Integration:** Configure the communication between the P4 switches and the control plane modules to enable the complete framework functionality.

## Module-Specific Instructions

For detailed instructions on each module, please refer to the corresponding PDF files:

* `P4-ESTP Module - P4.pdf`
* `AMCE - java (ONOS, ODL, Flood, Beacon).pdf`
* `AMCE - Python (Ryu & POX).pdf`
* `LDMC - Beacon - java.pdf`, etc.
* `MLDM - java (ONOS, ODL, Flood, Beacon).pdf`
* `MLDM - Python (Ryu & POX).pdf`

## Dependencies

The project has the following dependencies:

* Mininet
* P4 compiler (`p4c`)
* P4 runtime environment (e.g., `simple_switch`)
* ONOS, ODL, Floodlight, Beacon, Ryu, or POX controllers
* Python 3
* Java Development Kit (JDK)
* Python and Java libraries (see respective module files for detailed lists)
