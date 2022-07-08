gcloud sql instances create book-sql

NAME: book-sql
DATABASE_VERSION: MYSQL_8_0
LOCATION: us-central1-b
TIER: db-n1-standard-1
PRIMARY_ADDRESS: 34.123.193.113
PRIVATE_ADDRESS: -
STATUS: RUNNABLE

============================
gcloud sql databases create bookstore --instance book-sql

Created database [bookstore].
instance: book-sql
name: bookstore
project: norse-wavelet-354919

============================
gcloud sql instances describe book-sql | grep connectionName

connectionName: norse-wavelet-354919:us-central1:book-sql

===========================
