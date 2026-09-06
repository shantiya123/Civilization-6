package Game.Client.Synchronization;

/** Recoverable result used by later transport code to request a fresh snapshot. */
public enum ApplyResult { APPLIED, DUPLICATE_OR_OLDER, GAP, FAILED }
