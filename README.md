# 🧾 Stocky – Microservicio ERP para autónomos y pequeñas empresas

**Stocky** es una plataforma modular y escalable construida con microservicios que proporciona una solución ERP moderna diseñada específicamente para autónomos y pequeñas empresas. Desarrollada con **Spring Boot 3**, **Java 17+** y **Maven**, combina lo mejor de la comunicación síncrona y asíncrona utilizando **REST** y **Apache Kafka**.

---

## 🚀 Características

- ✅ Arquitectura basada en microservicios
- 🔐 Sistema de autenticación seguro y extensible
- 📦 Gestión completa de inventario, ventas, compras y pagos
- 🧾 Facturación automatizada
- 🧑‍🤝‍🧑 Gestión de clientes, empleados y proveedores
- 🔔 Notificaciones internas
- 📬 Comunicación mediante REST (bloqueante y no bloqueante con WebClient) y Apache Kafka (arquitectura basada en eventos)
- 🧩 Escalable, modular y fácil de mantener

---

## 📁 Estructura del Proyecto

```plaintext
/Stocky/
│
├── core-services/                     # Infraestructura y orquestación
│   ├── discovery-stocky-service/              # API Gateway
│   ├── registry-stocky-service/             # Eureka Server
│   └── message-stocky-broker/               # Kafka
│
├── identity-services/                # Seguridad y control de acceso
│   └── auth-stocky-service/                # Autenticación y autorización
│
├── business-services/                # Lógica principal del negocio
│   ├── customer-stocky-service/              # Clientes
│   ├── employee-stocky-service/            # Empleados
│   ├── supplier-stocky-service/            # Proveedores
│   ├── product-stocky-service/             # Productos
│   ├── inventory-stocky-service/           # Inventario
│   ├── purchase-stocky-service/            # Compras
│   ├── sale-stocky-service/               # Ventas
│   ├── payment-stocky-service/             # Pagos
│   ├── invoice-stocky-service/             # Facturas
│   └── issue-stocky-service/               # Incidencias
│
├── communication-services/           # Notificaciones, emails, etc.
│   └── notification-stocky-service/        # Notificaciones

└── shared-libraries/                 # Librerías comunes (DTOs, utils, seguridad, etc.)
```

