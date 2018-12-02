from nerd import NERD

text = "Rocky movie"

API_KEY = 'fsul4g5ijejbaab0l66k93ai1qprudk4'
timeout = 10000
n = NERD('nerd.eurecom.fr', API_KEY)
n.extract(text, 'combined', timeout)

