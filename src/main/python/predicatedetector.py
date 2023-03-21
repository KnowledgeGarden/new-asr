import spacy
import json 
from spacy.matcher import PhraseMatcher
nlp = spacy.load("en_core_web_md")
antecedents = [
  "is", "are", "was","were", "is not", "isn't",
  "are not", "aren't","was not", "wasn't", "were not"
  "weren't",  "does", "does not", "doesn't", 
  "did", "did not", "didn't",
  "can be", "could be", "may be", "might be", "will be",
  "could be",
  "might", "might not", "is thought to","was thought to", 
  "can", "cannot", "can't", "will", "will not","won't",
  "may", "may not", "could", "could not",
  "has been thought to have been", "have been thought to have been",
  "has not been thought to have been", "have not thought to have been",
  "is thought to have been", "are thought to have been",
  "has not been thought to have been", "have not thought to have been",
  "is not thought to have been", "are not thought to have been",
  "was not thought to have been", "wasn't thought to have been",
  "were not thought to have been", "weren't thought to have been",
  "has been thought to", "are thought to", "have been thought to",
  "is not thought to", "are not thought to", "aren't thought to",
  "was not thought to","wasn't thought to", "has not been thought to",
  "have not thought to"
]
predicates = [
  "treat", "treats", "treated", "treated by",
  "cause", "causes", "caused", "caused by",
  "prevent", "prevents", "prevented", "prevented by",
  "predispose", "predisposes", "predisposed", "predisposed by",
  "encourage", "encourages", "encouraged", "encouraged by",
  "discourage", "discourages", "discouraged", "discouraged by",
  "catalyze", "catalyzes", "catalyzed", "catalyzed by",
  "conjugate", "conjugates", "conjugated", "conjugated by",
  "connect", "connects to", "connects with", "connects", "connected", "connected with", "connected by",
  "considered as",
  "consume", "consumes", "consumed", "consumed by",
  "create", "creates", "created", "created by",
  "acetylate", "acetylates", "acetylated", "acetylated by",
  "deacetylate", "deacetylates", "deacetylated", "deacetylated by",
  "absorb", "absorbs", "absorbed", "absorbed by",
  "accelerate", "accelerates", "accelerated", "accelerated by",
  "decelerate", "decelerates", "decelerated", "decelerated by",
  "accumulate", "accumulates", "accumulated", "accumulated by",
  "act as", "acts as", "acted as",
  "activate", "activates", "activated", "activated by",
  "deactivate", "deactivates", "deactivated", "deactivated by",
  "adapt", "adapts", "adapted", "adapted by",
  "add", "adds", "added", "added by",
  "affect", "affects", "affected", "affected by",
  "aggregate", "aggregates", "aggregated", "aggregated by",
  "believe", "believes", "believed"
]
antMatcher = PhraseMatcher(nlp.vocab)
predMatcher = PhraseMatcher(nlp.vocab)
antPatterns = [nlp.make_doc(term) for term in antecedents]
predPatterns = [nlp.make_doc(term) for term in predicates]
antMatcher.add("prelist", antPatterns)
predMatcher.add("predlist", predPatterns)

doc = nlp("Greenhouse gasses have been thought to cause climate change")
# doc = nlp("Climate change has been thought to have been caused by greenhouse gasses")
# doc = nlp("Scientists believe  that co2 causes climate change")
#doc = nlp("Scientists believe that climate change is caused by  carbon dioxide")
antMatches = antMatcher(doc)
predMatches = predMatcher(doc)

data = []
ants = []
jsn = {}

for mid, start, end in antMatches:
  jsn['strt'] = start
  jsn['enx'] = end
  foo = doc[start:end]
  jsn['txt'] = str(foo)
  ants.append(jsn)
  jsn = {}
data.append(ants)

preds = []
jsn = {}
for mid, start, end in predMatches:
  jsn['strt'] = start
  jsn['enx'] = end
  foo = doc[start:end]
  jsn['txt'] = str(foo)
  preds.append(jsn)
  jsn = {}
data.append(preds)

print("DID: ",data)
