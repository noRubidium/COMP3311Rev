read(X):
  if T >= writeTS(X) then
    execute read(X)
    if T >= readTS(X) then
      readTS(X) <- T
  else
    rollback the transaction and restart

write(X):
  if T >= readTS(X) and T >= writeTS(X) then
    execute write(X)
    writeTS(X) <- T
  else
    rollback the transaction and restart
