<div align="center">

![Header](https://capsule-render.vercel.app/api?type=waving&color=0:0D1117,50:1A1B27,100:0078D4&height=200&section=header&text=Mahmoud%20Salem&fontSize=44&fontColor=FFFFFF&fontAlignY=35&desc=Software%20and%20Data%20Engineer%20%C2%B7%20Trustworthy%20AI%20Research&descSize=17&descAlignY=56&animation=fadeIn)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/ma7moudalysalem)
[![Email](https://img.shields.io/badge/Email-EA4335?style=for-the-badge&logo=gmail&logoColor=white)](mailto:ma7moudalysalem@gmail.com)
[![Portfolio](https://img.shields.io/badge/Portfolio-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ma7moudalysalem/Portfolio)
[![Profile Views](https://komarev.com/ghpvc/?username=ma7moudalysalem&style=for-the-badge&color=0078D4&label=PROFILE+VIEWS)](https://github.com/ma7moudalysalem)

</div>

## About

Software and data engineer in Cairo with about five years of building production systems in .NET and data platforms on Azure, and an M.Sc. student at Cairo University. I came to software from physics, and I work at the point where large systems, data and AI meet: making AI-assisted software that can explain and check what it says.

- **Building:** enterprise and government platforms in ASP.NET Core, SQL Server and Azure, from the application to its security perimeter; team lead and architect of [ScholarPath](https://github.com/ma7moudalysalem/ScholarPath).
- **Data engineering:** ETL/ELT pipelines and warehouses on Azure (Data Factory, Synapse), medallion lakehouses, and streaming designs with Kafka, Flink and Spark.
- **Researching:** retrieval-augmented generation, explainable recommendation, and checking model answers against formal rules, in English and Arabic.
- **Teaching:** instructor and mentor for 300+ students at Cairo University, DEPI and in private sessions, across nine computer-science subjects.

---

## Professional work

**Software Engineer at Positive Side Horizons (2023 – present).** The company builds a suite of enterprise products for government organisations in the Gulf and Egypt, covering strategy, performance and project management. I am the lead developer on two of the suite's products, and I designed and built two of its shared components from scratch: a secure gateway and an audit library.

| What I own | Role | |
|---|---|---|
| 🏛️ **Strategy and organisational-excellence platform** | Lead developer | Balanced scorecards, cascaded objectives, initiatives and indicators, bilingual Arabic and English |
| 🛡️ **Secure gateway** | Designed and built from scratch | One controlled entry point for the suite's web applications |
| 📜 **Audit library** | Designed and built from scratch | Field-level audit history, shared across the suite |
| 🔗 **Digital-transformation platform** | Lead developer | Government platform with enterprise identity and directory integration |

**At a glance:** a large export made about 15× faster · a core screen cut from 500+ queries to 5 · one audit library in six products, across three .NET runtimes and three ORMs · more than two dozen applications published through one gateway, with no change to their code.

### ⚡ Performance engineering

I profile one request at a time, find what actually dominates each slow path, and measure every change before and after.

| Operation | Result | Cause and fix |
|---|---|---|
| Large document export | **About 15× faster**, with a byte-identical file | The ORM re-checked every loaded object for changes before each query; switched that off for the read-only export |
| Saving a large design | **About 6× faster** | The same work was done twice in one save; removed the duplicate pass |
| Loading a hierarchical view | **500+ queries → 5**, about 3× faster | One extra lookup for every label (N+1); loaded the labels once |
| Data shown on every page | **Served from cache on most pages** | A blocking call to another service on each page load; made it cached and bounded |

Per-request profiling also showed that much of the waiting came from cold starts and static assets rather than from the database, so part of the work went into keeping the application warm and preparing every screen in the background.

`NHibernate` `ASP.NET` `SQL Server` `profiling`

### 📜 Audit library

**What I built:** field-level history of every change (who, when, where, old value and new value) plus sign-ins, failed sign-ins, and permission and setting changes. Changes are captured by an ORM interceptor, with no change to business code, and written to a separate, append-only store. One save becomes one record with a row per changed field, and an admin screen lets you filter, search and export them.

**Then I made it a product of its own:** one package now used by **six products**.

- Targets .NET Framework 4.5, .NET Standard 2.0 and .NET 6+, and works with NHibernate, Entity Framework 6 and EF Core 3.1 to 10, tested on each combination.
- Handles the hard cases: changes the ORM later discards are not recorded as phantom edits; sensitive fields can be masked or ignored; background synchronisation is labelled as "System" rather than a user; and the same change is never recorded twice in one request.

`C#` `NHibernate` `EF Core` `EF6` `SQL Server` `NuGet`

### 🛡️ Secure gateway

**The problem:** a large suite of web applications and its single sign-on had to be reachable by users outside the organisation's network, without rewriting any of the applications.

**What I built:** a reverse-proxy gateway that is the suite's one controlled entry point.

- Only explicitly approved routes are published.
- Sign-in works the same way for browsers and for server-to-server calls.
- No application code was changed.

The work started with a security review of the suite's identity and access paths.

`reverse proxy` `.NET` `OpenID Connect` `network design`

### 🔐 Permissions and identity integration

- Introduced granular, per-group administrative permissions.
- Kept roles consistent across products through messaging, with a safeguard that prevents administrators from locking everyone out.
- Built an API for a cross-product permissions report.

`OpenID Connect` `messaging` `ASP.NET`

### 🧩 Product work

- **Import and export:** Arabic text encoding, date formats and referential consistency in large structured files.
- **Data integrity:** made setup scripts safe to re-run, and audited 110 lazy-loading call sites after an ORM refactor.
- **Everyday reliability:** session handling, validation rules shared across screens, and bilingual display throughout.

### 🌐 Also at PSH

- APIs and Angular portals for a product serving 10,000+ users · `ASP.NET Core` `RabbitMQ` `Angular` `ELK`

### 🏥 Before PSH: DMS (Data Management Systems), Aug 2022 – Apr 2023

Software Engineer on national healthcare and government systems in Egypt.

| System | What it does | |
|---|---|---|
| 🏥 **ICU management system** | National system for intensive-care units across **500+ hospitals**. I built its monitoring screens and its reports | `ASP.NET Core` `SQL Server` `real-time` |
| 🗺️ **Health analytics dashboards** | I built an interactive map of Egypt's **27 governorates**, each coloured by its number of cases. Clicking a governorate shows its cases for each disease, then drills down to every district inside it and its cases | `GIS` `interactive maps` `SQL Server` |
| 📝 **National marriage registration** | Nationwide automation of a government civil-registration workflow. I built the marriage registration form and the system's reports | `Oracle` `ASP.NET MVC` `jQuery` |

<details>
<summary><b>Freelance work and other results</b></summary>
<br>

- **Freelance (2021 – present)** — e-commerce, patient portals and multi-tenant SaaS for clients in the US, UK and UAE · `ASP.NET Core` `Angular` `Stripe`

Results: data-processing time down 70% with Azure Data Factory and Synapse; cloud costs down 35%; systems handling 1M+ daily transactions; 10,000+ users served at 99.9% uptime.

</details>

---

## Research

**[ScholarPath](https://github.com/ma7moudalysalem/ScholarPath)** — a gated, bilingual platform whose recommendations and eligibility checks are deterministic, explainable rules, with an assistant that answers only from retrieved documents. I led the team and designed the architecture, the AI features and their evaluation, which ships with the code and is reproducible:

- 528 real scholarships from DAAD, Erasmus Mundus and 29 government and university programmes, and 1,712 student profiles calibrated to UNESCO statistics for twelve Arab countries;
- eligibility verdicts that agree with DAAD's own published criteria on all 39,300 compared cases;
- fused English and Arabic retrieval, and answers judged by two independent models.

**Current interests:** trustworthy and multilingual RAG · LLM evaluation · neuro-symbolic verification (formal methods with language models) · Arabic NLP.

Reading notes: [**research-notebook**](https://github.com/ma7moudalysalem/research-notebook) — paper summaries across medical imaging, vision, foundation models, multimodal AI, AI systems and ML theory.

---

## Data engineering

| Project | What it is |
|---|---|
| 🏥 [**Healthcare Data Warehouse**](https://github.com/ma7moudalysalem/healthcare-data-warehouse) | End-to-end healthcare data platform on Azure: bronze, silver and gold layers (medallion), batch and streaming, star schema with SCD2, from ingestion to dashboards |
| 💳 [**Fawry Data Engineering**](https://github.com/ma7moudalysalem/fawry-data-engineering-case-study) | Lambda architecture for real-time fraud detection and financial reconciliation · `Kafka` `Flink` `Spark` |
| 📘 [**Fundamentals of Data Engineering — notes**](https://github.com/ma7moudalysalem/Fundamentals-of-Data-Engineering) | Chapter-by-chapter LaTeX notes on Reis & Housley (O'Reilly, 2022) |
| 🎖️ [**DEPI · Microsoft Data Engineer**](https://github.com/ma7moudalysalem/DEPI-Microsoft-Data-Engineer) | Digital Egypt Pioneers Initiative, Microsoft Data Engineer track (Nov 2025 – Jul 2026) |

---

## Writing

Long-form references I wrote to understand a subject end to end, and to teach it.

| | |
|---|---|
| 🏗️ [**System Design Fundamentals**](https://github.com/ma7moudalysalem/system-design-fundamentals) | A book that starts at a single machine and explains the mechanism, the cost and the failure behind every piece |
| ⚙️ [**ASP.NET Core in .NET 10: The Complete Backend Engineering Guide**](https://github.com/ma7moudalysalem/aspnetcore-dotnet10-complete-guide) | A backend engineering book, with its companion source code |
| 🌿 [**Git & GitHub Mastery**](https://github.com/ma7moudalysalem/git-github-mastery) | From zero to CI/CD pipelines, every concept built step by step |
| 🧮 [**DSA Mastery in C++**](https://github.com/ma7moudalysalem/dsa-mastery-cpp) | A 16-week, problem-heavy data-structures and algorithms course |
| 🧩 [**Problem-Solving Patterns**](https://github.com/ma7moudalysalem/Problem-Solving-Patterns) | 18 algorithm patterns in C#, from sliding window to topological sort and union-find |
| 🧠 [**Deep Dive into LLMs**](https://github.com/ma7moudalysalem/Deep-Dive-into-LLMs-like-ChatGPT) | Typeset notes on Karpathy's lecture: pre-training, transformers, RLHF, reasoning, LLM security |

---

## Experience

| When | Role |
|---|---|
| Apr 2023 – present | Software Engineer · Positive Side Horizons (PSH) · enterprise and government platforms for clients in the Gulf and Egypt |
| 2025 – 2026 | Data Engineer (internship) · Digital Egypt Pioneers Initiative (DEPI), Microsoft Data Engineer track |
| Aug 2022 – Apr 2023 | Software Engineer · DMS (Data Management Systems) · national healthcare and government systems in Egypt |
| 2021 – present | Freelance Software Engineer · clients in the US, UK and UAE |

## Education

| | |
|---|---|
| M.Sc. in Data Science | Cairo University · *in progress* |
| Postgraduate Diploma in Computer Science | Cairo University (FGSSR), 2024–2026 · GPA 3.65 / 4 |
| Professional Diploma, Web Development and BI | ITI, 2021–2022 |
| Microsoft Data Engineer track | DEPI, 2025–2026 |
| B.Sc. in Physics | Menoufia University, 2015–2019 |

## Teaching

Instructor and mentor for 300+ students at Cairo University, DEPI and in private sessions.

| Where | Subjects |
|---|---|
| Cairo University | Operating Systems · Compiler Design · Computer Architecture · Theory of Computation · Mathematics for CS · Programming Language Paradigms |
| Cairo University, DEPI and private | Database Systems · Algorithms and Data Structures |
| DEPI and private | Data Science |

---

## Tools

| | |
|---|---|
| **Backend** | C# · ASP.NET Core · EF Core · NHibernate · SQL Server · PostgreSQL · Oracle · Redis · RabbitMQ · Hangfire · SignalR |
| **Data engineering** | Azure Data Factory · Synapse Analytics · ETL/ELT · data warehousing · medallion architecture · Kafka · Flink · Spark · Python · Pandas · T-SQL |
| **Frontend** | React · Angular · TypeScript · Tailwind |
| **AI** | retrieval-augmented generation · embeddings and BM25 · OpenAI and Azure OpenAI · LLM evaluation |
| **Security and infrastructure** | Reverse proxies · network perimeter design · OpenID Connect · OAuth 2.0 · single sign-on |
| **Cloud and practice** | Azure · AWS · Docker · GitHub Actions · Clean Architecture · CQRS · DDD |

---

<div align="center">

<img width="49%" alt="GitHub stats" src="https://github-profile-summary-cards.vercel.app/api/cards/stats?username=ma7moudalysalem&theme=tokyonight" />
<img width="49%" alt="Top languages" src="https://github-profile-summary-cards.vercel.app/api/cards/repos-per-language?username=ma7moudalysalem&theme=tokyonight" />

<img width="70%" alt="Contribution streak" src="https://streak-stats.demolab.com?user=ma7moudalysalem&theme=tokyonight&hide_border=true&background=0D1117&ring=0078D4&fire=0078D4&currStreakLabel=0078D4" />

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/ma7moudalysalem/ma7moudalysalem/output/github-snake-dark.svg" />
  <source media="(prefers-color-scheme: light)" srcset="https://raw.githubusercontent.com/ma7moudalysalem/ma7moudalysalem/output/github-snake.svg" />
  <img alt="contribution snake" src="https://raw.githubusercontent.com/ma7moudalysalem/ma7moudalysalem/output/github-snake-dark.svg" />
</picture>

</div>
