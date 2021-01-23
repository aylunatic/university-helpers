# university-helpers
All small programms done for practice, fun or because "it is quicker to just write a program that will do it" instead of doing it myself within 15 minutes.

## Raid5_Restorer
Simple Java program without UI. Used to automate an assignment where we had to restore missing data blocks in a RAID5 System (who would have thought with that name).
Pretty much hardcoded for that specific task.
Will read three hexadecimal numbers from stdin which represent actual data, one additional hexadecimal that builds from the parity bits of the other 3 number and then print another number as hexadecimal and bitstring, which is the "corrupted" data block.

